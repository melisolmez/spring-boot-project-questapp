package com.project.questapp.controller;

import com.project.questapp.model.Comment;
import com.project.questapp.model.Post;
import com.project.questapp.model.User;

public record CommentRequest(
  Long userId,
  Long postId,
  String text
) {

    public Comment toCommentRequest(){
        User user=new User();
        Post post=new Post();
        Comment comment=new Comment();
        user.setId(userId);
        post.setId(postId);
        comment.setText(text);
        comment.setUser(user);
        comment.setPost(post);
        return comment;
    }
}
