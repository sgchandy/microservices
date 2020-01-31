package com.rest.webservices.restfulws.beans.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@ApiModel("The User Definition")
public class User {

    @Size(min = 2, message = "Invalid name. Has to be more than 2 characters")
    @ApiModelProperty(notes = "Name should have atleast 2 characters, this is for swagger")
    private String name;

    private Integer id;

    @Past(message = "Date of Birth cannot be in the future")
    @ApiModelProperty(notes = "DOB should be in the past")
    private Date dateOfBirth;

    private List<Posts> posts;


    protected User(){

    }

    public User(int id, String name, Date dateOfBirth) {
        super();
        this.name=name;
        this.id=id;
        this.dateOfBirth=dateOfBirth;
        posts = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public void setPost(Posts post){
        int count = posts.size() +1 ;
        post.setPostId(count);
        this.posts.add(post);
    }

    public Posts getPost(int postId) {
        for(Posts post : posts){
            if(post.getPostId() == postId){
                return post;
            }
        }
        return null;
    }

    public List<Posts> deletePost(int postId){
        Iterator<Posts> posts = this.getPosts().iterator();
        while(posts.hasNext()){
            Posts temp = posts.next();
            if(temp.getPostId() == postId){
                posts.remove();
            }
        }
        return this.getPosts();
    }
}
