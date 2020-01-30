package com.rest.webservices.restfulws.dao.user;

import com.rest.webservices.restfulws.beans.user.Posts;
import com.rest.webservices.restfulws.beans.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static{
        users.add( new User(1,"John", new Date()));
        users.add(new User(2,"Jane", new Date()));
        users.add(new User(3,"Doe", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(users.size()+1);
        users.add(user);
        return user;
    }


    public User getUser(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public Posts savePosts(int id, Posts post){
        for(User user : users){
            if(user.getId() == id){
                post.setUserId(id);
                user.setPost(post);
                return post;
            }
        }
        return null;
    }


    public Posts getPost(int id, int postId){
        for(User user : users){
            if(user.getId() == id){
                return user.getPost(postId);
            }
        }
        return null;
    }

    public List<Posts> getPosts(int id) {
        for(User user : users){
            if(user.getId() == id){
                return user.getPosts();
            }
        }
        return null;
    }

    public List<Posts> deletePost(int id, int postId) {
        for(User user : users){
            if(user.getId() == id){
                return user.deletePost(postId);
            }
        }
        return null;
    }
}
