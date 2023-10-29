package com.project.questapp.service.like;

import com.project.questapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService implements LikeServiceInterface {
    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public User updateUser(User user, Long id) {
        return null;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }
}
