package com.steve.bug_bounty_system.mapper;

import com.steve.bug_bounty_system.dto.CreateUserRequest;
import com.steve.bug_bounty_system.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest dto) {
        User user = new User(dto.getUsername());
        return user;
    }
}
