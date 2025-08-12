package com.steve.bug_bounty_system.controller;

import com.steve.bug_bounty_system.dto.CreateUserRequest;
import com.steve.bug_bounty_system.mapper.UserMapper;
import com.steve.bug_bounty_system.model.User;
import com.steve.bug_bounty_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity createNewUser(@Valid @RequestBody CreateUserRequest req) {
        User newUser = userMapper.toEntity(req);
        userService.saveUser(newUser);
        return ResponseEntity.status(201).build();
    }
}
