package com.rest.webservices.restfulws.beans.user;

import java.util.Date;

public class Posts {

    private int userId;
    private int postId;
    private Date postDate;
    private String title;
    private String message;

    protected Posts(){}

    public Posts(int userId, int postId, Date postDate, String title, String message){
        super();
        this.userId=userId;
        this.postId = postId;
        this.postDate=postDate;
        this.title=title;
        this.message=message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
