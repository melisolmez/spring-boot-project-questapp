package com.project.questapp.controller;

import com.project.questapp.model.Post;
import com.project.questapp.service.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam Optional<Long> userId){
      List<Post> posts=postService.getAllPosts(userId);
      if(!posts.isEmpty()){
          return new ResponseEntity<>(posts,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<?> getOnePostById(@PathVariable long postId){
        if(postService.getOnePostById(postId).isPresent()){
            return new ResponseEntity<>("Post found", HttpStatus.OK);
        }
        return new ResponseEntity<>("Post not found",HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Post> createOnePost(@RequestBody PostRequest postRequest) {
        Post savedPost = postService.savePost(postRequest.toPostService());
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        if(postService.updatePostById(postId,postUpdateRequest.toPostService())!=null){
            return new ResponseEntity<>("Post update successfully",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Post doesn't update ",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable long postId){
        if(postService.deletePostById(postId)){
            return new ResponseEntity<>("Post deleted successfully",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Post not found",HttpStatus.NOT_FOUND);
    }

}
