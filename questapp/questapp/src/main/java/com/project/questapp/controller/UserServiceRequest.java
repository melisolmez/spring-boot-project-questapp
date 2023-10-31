package com.project.questapp.controller;

import com.project.questapp.entity.User;

public record UserServiceRequest(
        Long id,
        String username,
        String password
) {
    User toServiceRequest() {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return user;
    }
}
