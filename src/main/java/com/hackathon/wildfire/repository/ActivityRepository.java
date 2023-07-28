package com.hackathon.wildfire.repository;

import com.hackathon.wildfire.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByUserId(String userId);
}
