package com.rest.webservices.restfulws.controller;

import com.rest.webservices.restfulws.beans.helloworld.HelloWorldBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {


    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-get")
    public String HelloGet(){
        return "Hello World Get";
    }

    @GetMapping("/hello-bean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("This is a new bean");
    }


    @GetMapping("/hello-path-variable/{name}")
    public HelloWorldBean helloWorldName(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello %s ! This is a new bean.", name));
    }


    @GetMapping("/hello-path-variable/{name}/{age}")
    public HelloWorldBean helloWorldNameAge(@PathVariable String name, @PathVariable int age){
        return new HelloWorldBean(String.format("Hello %s , it says you are %s years old ! ", name, age));
    }


}
