package com.project.questapp.service.comment;

import com.project.questapp.model.Comment;
import com.project.questapp.model.Post;
import com.project.questapp.model.User;
import com.project.questapp.repository.CommentRepository;
import com.project.questapp.service.post.PostService;
import com.project.questapp.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements CommentServiceInterface {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;
    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent()&& postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            return commentRepository.findByPostId(postId.get());
        }else
            return commentRepository.findAll();
    }

    @Override
    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment createOneComment(Comment comment) {
        Optional<User> user=userService.findUserById(comment.getUser().getId());
        Optional<Post> post=postService.getOnePostById(comment.getPost().getId());

        if(user.isPresent()&&post.isPresent()){
          Comment newComment=new Comment();
          newComment.setPost(comment.getPost());
          newComment.setUser(comment.getUser());
          newComment.setText(comment.getText());

          return commentRepository.save(newComment);
        }
       return null;
    }

    @Override
    public Comment updateOneCommentById(Long commentId,Comment comment) {
       Optional<Comment> existcomment= commentRepository.findById(commentId);
       if(existcomment.isPresent()){
           Comment newComment=new Comment();
           newComment.setText(comment.getText());
           return commentRepository.save(newComment);
       }
       return null;
    }

    @Override
    public boolean deleteCommentById(Long commentId) {
         Comment existComment=commentRepository.findById(commentId).orElse(null);
         if(existComment==null){
             return false;
         }
         return true;
    }
}
