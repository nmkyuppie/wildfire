package com.hackathon.wildfire.repository;

import com.hackathon.wildfire.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
