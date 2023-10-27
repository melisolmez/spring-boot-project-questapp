package com.project.questapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestappApplication.class, args);
		/*
		 @Override
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> findUserById(Long id){
       Optional<User> userOptional=userRepository.findById(id);
       if(userOptional.isPresent())
        return userRepository.findById(id);

       return Optional.empty();
    }
    public User updateUser(User user, Long id){
        User existingUser=userRepository.findById(id).orElse(null);
        if(existingUser==null){
           return null;
        }
        existingUser.setPassword(user.getPassword());
        existingUser.setUsername(user.getUsername());
        userRepository.save(existingUser);

        return existingUser;
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
		 */
	}

}
