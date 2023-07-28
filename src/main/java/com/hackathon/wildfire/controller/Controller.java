package com.hackathon.wildfire.controller;

import com.hackathon.wildfire.entity.Activity;
import com.hackathon.wildfire.entity.User;
import com.hackathon.wildfire.service.ActivityService;
import com.hackathon.wildfire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/activities")
    public List<Activity> getAllActivity() {
        return activityService.getAllActivity();
    }
}
