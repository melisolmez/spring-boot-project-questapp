package com.project.questapp.service.user;

import com.project.questapp.entity.User;
import com.project.questapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional<User> userOptional=userRepository.findById(id);
        if(userOptional.isPresent())
            return userRepository.findById(id);

        return Optional.empty();
    }

    @Override
    public User updateUser(User user, Long id) {
        User existingUser=userRepository.findById(id).orElse(null);
        if(existingUser==null){
            return null;
        }
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(existingUser.getPassword());

        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public boolean deleteUserById(Long id) {
        User existingUser=userRepository.findById(id).orElse(null);
        if(existingUser==null){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
