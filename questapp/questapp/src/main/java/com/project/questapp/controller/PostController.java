package com.project.questapp.controller;

import com.project.questapp.entity.Post;
import com.project.questapp.request.PostRequest;
import com.project.questapp.service.post.PostService;
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
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
       return postService.getAllPosts(userId);
    }
    @GetMapping("/{postid}")
    public Optional<Post> getOnePostById(@PathVariable long postid){
        return postService.getOnePostById(postid);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostRequest postRequest){
        return postService.savePost(postRequest.toPostService());
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable long postId){
        postService.deletePostById(postId);
    }

}
