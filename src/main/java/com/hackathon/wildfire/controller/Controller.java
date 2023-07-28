package com.hackathon.wildfire.controller;

import com.hackathon.wildfire.domain.ActivityResponse;
import com.hackathon.wildfire.entity.Activity;
import com.hackathon.wildfire.entity.User;
import com.hackathon.wildfire.repository.ActivityRepository;
import com.hackathon.wildfire.repository.UserRepository;
import com.hackathon.wildfire.service.ActivityService;
import com.hackathon.wildfire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/user/add", consumes = {"application/json"}, produces = {"application/json"})
    public void addUser(@RequestBody List<User> users) {
        userRepository.saveAll(users);
    }

    @GetMapping("/activities")
    public List<Activity> getAllActivity() {
        return activityService.getAllActivity();
    }

    @PostMapping(path = "/activity/add", consumes = {"application/json"}, produces = {"application/json"})
    public void addActivity(@RequestBody List<Activity> activities) {
        activityRepository.saveAll(activities);
    }

    @GetMapping("/{userId}/activityPrediction")
    public List<ActivityResponse> activityPrediction(@PathVariable String userId) {
        return activityService.activityPrediction(userId);
    }
}
