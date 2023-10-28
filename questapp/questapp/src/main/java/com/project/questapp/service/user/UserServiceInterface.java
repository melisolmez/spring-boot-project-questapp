package com.project.questapp.service.user;

import com.project.questapp.entity.User;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface UserServiceInterface {
    List<User> findAllUsers();

    User saveUser(User user);

    Optional<User> findUserById(Long id);

    User updateUser(User user,Long id);

    boolean deleteUserById(Long id);

}
