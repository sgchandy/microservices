package com.rest.webservices.restfulws.beans.user;

import java.util.Date;

public class User {

    private String name;
    private Integer id;
    private Date dateOfBirth;

    protected User(){

    }

    public User(int id, String name, Date dateOfBirth) {
        super();
        this.name=name;
        this.id=id;
        this.dateOfBirth=dateOfBirth;
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


}
