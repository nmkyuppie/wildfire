package com.hackathon.wildfire.service;

import com.hackathon.wildfire.entity.User;
import com.hackathon.wildfire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        User user1 = User.builder().name("Mani").build();
        User user2 = User.builder().name("Nalan").build();
        userRepository.saveAll(Arrays.asList(user1, user2));
        return userRepository.findAll();
    }

}
