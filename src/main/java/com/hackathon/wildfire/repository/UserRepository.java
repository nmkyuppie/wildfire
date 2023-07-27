package com.hackathon.wildfire.repository;

import com.hackathon.wildfire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
