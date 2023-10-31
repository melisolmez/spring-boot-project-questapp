package com.project.questapp.request;

import com.project.questapp.entity.Post;
import com.project.questapp.entity.User;

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
