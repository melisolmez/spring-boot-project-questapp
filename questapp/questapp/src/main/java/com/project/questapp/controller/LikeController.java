package com.project.questapp.controller;

import com.project.questapp.model.Like;
import com.project.questapp.service.like.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLike(@RequestParam Optional<Long> userId,
                                 @RequestParam Optional<Long> postId){
        return likeService.getAllLike(userId,postId);
    }
    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return likeService.getOneLikeById(likeId);
    }



}
