package com.steve.bug_bounty_system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CreateUserRequest {

    @NotBlank(message = "Username is required.")
    private String username;

    public CreateUserRequest(String username) {
        this.username = username;
    }
}
