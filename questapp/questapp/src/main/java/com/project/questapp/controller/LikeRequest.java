package com.project.questapp.controller;

import com.project.questapp.model.Like;
import com.project.questapp.model.Post;
import com.project.questapp.model.User;

public record LikeRequest(
        Long userId,
        Long postId
) {

    public Like toLikeRequest(){
        Like like=new Like();
        User user=new User();
        Post post=new Post();
        user.setId(userId);
        post.setId(postId);
        like.setPost(post);
        like.setUser(user);
        return like;
    }
}
