package com.project.questapp.service.comment;

import com.project.questapp.model.Comment;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface CommentServiceInterface {

    List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

    Comment getOneCommentById(Long commentId);

    Comment createOneComment(Comment comment);

    Comment updateOneCommentById(Long commentId,Comment comment);

    void deleteCommentById(Long commentId);
}
