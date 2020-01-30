package com.rest.webservices.restfulws.controller.user;

import com.rest.webservices.restfulws.beans.user.Posts;
import com.rest.webservices.restfulws.beans.user.User;
import com.rest.webservices.restfulws.dao.user.UserDaoService;
import com.rest.webservices.restfulws.exception.user.PostNotFoundException;
import com.rest.webservices.restfulws.exception.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;


    @PostMapping("/createuser")
    public ResponseEntity<Object> createuser(@Valid @RequestBody User user){
        service.save(user);
        //Generates a Location URI and puts it in the header
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{id}").buildAndExpand(user.getId()).toUri();
        //sets the status of the response to 201 (Created)
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User usrs = service.getUser(id);
        if(usrs== null){
            throw new UserNotFoundException("id-"+id + " : Not found");
        }
        return usrs;
    }


    @PostMapping("/savePost/{id}")
    public Posts savePost(@PathVariable  int id, @RequestBody Posts data){
        Posts post = service.savePosts(id, data);
        if( post == null){
            throw new UserNotFoundException(String.format("Post could not be added fr the user if %s",  id));
        }
        return post;
    }

    @GetMapping("/getAllPost/{id}")
    public List<Posts> getAllPosts(@PathVariable  int id ){
        List<Posts> posts = service.getPosts(id);
        if( posts == null || posts.size()<1){
            throw new PostNotFoundException(String.format("No posts found for user ID %s",  id));
        }
        return posts;
    }

    @GetMapping("/getPost/{id}/{postId}")
    public Posts getPost(@PathVariable  int id, @PathVariable int postId){
        Posts post = service.getPost(id, postId);
        if( post == null){
            throw new PostNotFoundException(String.format("Post ID %s for user ID %s, not found", postId, id));
        }
        return post;
    }


    @DeleteMapping("/deletePost/{id}/{postId}")
    public List<Posts> deletePost(@PathVariable int id, @PathVariable int postId){
        return service.deletePost(id, postId);
    }


}
