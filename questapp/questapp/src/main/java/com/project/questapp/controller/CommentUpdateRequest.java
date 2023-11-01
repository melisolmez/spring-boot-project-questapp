package com.project.questapp.controller;

import com.project.questapp.model.Comment;

public record CommentUpdateRequest(
        String text
) {
    public Comment toComment(){
        Comment comment=new Comment();
        comment.setText(text);
        return comment;
    }
}
