package com.project.questapp.controller;

import com.project.questapp.model.Like;
import com.project.questapp.service.like.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Like>> getAllLike(@RequestParam Optional<Long> userId,
                                                @RequestParam Optional<Long> postId){
       List<Like> likes=likeService.getAllLike(userId,postId);
       if(!likes.isEmpty()){
           return new ResponseEntity<>(likes, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{likeId}")
    public ResponseEntity<Like> getOneLike(@PathVariable Long likeId){
        Like like= likeService.getOneLikeById(likeId);
        if(like!=null){
            return new ResponseEntity<>(like,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Like> createOneLike(@RequestBody LikeRequest likeRequest){
        Like like= likeService.createOneLike(likeRequest.toLikeRequest());
        if(like!=null){
            return new ResponseEntity<>(like,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  @DeleteMapping("/{likeId}")
    public ResponseEntity<String> deleteLike(@PathVariable Long likeId){
        if(likeService.deleteLikeById(likeId)){
            return new ResponseEntity<>("Like deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Like not deleted",HttpStatus.NOT_FOUND);
  }


}
