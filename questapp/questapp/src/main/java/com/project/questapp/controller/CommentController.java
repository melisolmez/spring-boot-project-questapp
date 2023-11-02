package com.project.questapp.controller;

import com.project.questapp.model.Comment;
import com.project.questapp.service.comment.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Comment>> getAllComments(@RequestParam Optional<Long> userId,
                                                       @RequestParam Optional<Long> postId){
       List<Comment> comments=commentService.getAllCommentsWithParam(userId,postId);
       if(!comments.isEmpty()){
           return new ResponseEntity<>(comments, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getOneComment(@PathVariable Long commentId){
        Comment comment=commentService.getOneCommentById(commentId);
       if(comment!=null){
           return new ResponseEntity<>(comment,HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Comment> createOneComment(@RequestBody CommentRequest commentRequest){
        Comment comment= commentService.createOneComment(commentRequest.toCommentRequest());
        if(comment!=null){
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateRequest updateRequest){
        Comment comment=commentService.updateOneCommentById(commentId,updateRequest.toComment());
        if(comment!=null){
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteCommentById(@PathVariable Long commentId){
        if(commentService.deleteCommentById(commentId)) {
            return new ResponseEntity<>("Post deleted successfully",HttpStatus.OK);
        }
         return new ResponseEntity<>("Post not deleted successfully",HttpStatus.NOT_FOUND);
     }
}
