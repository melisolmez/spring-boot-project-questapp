package com.project.questapp.controller;

import com.project.questapp.model.Post;

public record PostUpdateRequest(
        String title,
        String text
) {
    public Post toPostService(){
        Post post=new Post();
        post.setTitle(title);
        post.setText(text);

        return post;
    }
}
