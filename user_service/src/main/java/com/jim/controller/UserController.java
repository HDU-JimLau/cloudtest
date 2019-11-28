package com.jim.controller;

import com.jim.pojo.User;
import com.jim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return service.findById(id);
    }
    @RequestMapping("/all")
    public List<User> getAll(){
        return service.findAll();
    }
}
