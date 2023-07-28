package com.hackathon.wildfire.service;

import com.hackathon.wildfire.entity.Activity;
import com.hackathon.wildfire.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivity() {
        activityRepository.save(Activity.builder().appId("something1").build());
        activityRepository.save(Activity.builder().appId("something1").build());
        return activityRepository.findAll();
    }
}
