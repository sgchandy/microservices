package com.rest.webservices.restfulws.controller.user;

import com.rest.webservices.restfulws.beans.user.User;
import com.rest.webservices.restfulws.dao.user.UserDaoService;
import com.rest.webservices.restfulws.exception.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

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

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user){
        return service.save(user);
    }



    @PostMapping("/createuser")
    public ResponseEntity<Object> createuser(@RequestBody User user){

        service.save(user);

        //Generates a Location URI and puts it in the header
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{id}").buildAndExpand(user.getId()).toUri();

        //sets the status of the response to 201 (Created)
        return ResponseEntity.created(location).build();
    }
}
