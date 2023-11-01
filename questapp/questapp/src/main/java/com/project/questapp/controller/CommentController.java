package com.project.questapp.controller;

import com.project.questapp.model.Comment;
import com.project.questapp.service.comment.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId){
                return commentService.getAllCommentsWithParam(userId,postId);
    }
    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentRequest commentRequest){
        return commentService.createOneComment(commentRequest.toCommentRequest());
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest updateRequest){
        return commentService.updateOneCommentById(commentId,updateRequest.toComment());
    }

     @DeleteMapping("/{commentId}")
    public void deleteCommentById(@PathVariable Long commentId){
         commentService.deleteCommentById(commentId);
     }
}
