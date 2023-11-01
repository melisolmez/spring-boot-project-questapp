package com.project.questapp.controller;

import com.project.questapp.model.Post;
import com.project.questapp.model.User;

public record PostRequest(
        Long userId,
        String text,
        String title

) {

    public Post toPostService(){
        Post post=new Post();
        User user=new User();
        user.setId(userId);
        post.setText(text);
        post.setTitle(title);
        post.setUser(user);

        return post;
    }
}
