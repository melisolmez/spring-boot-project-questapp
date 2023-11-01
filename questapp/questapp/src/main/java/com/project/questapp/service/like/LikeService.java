package com.project.questapp.service.like;

import com.project.questapp.model.Like;
import com.project.questapp.repository.LikeRepository;
import com.project.questapp.service.post.PostService;
import com.project.questapp.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService implements LikeServiceInterface {

  private final LikeRepository likeRepository;
  private final UserService userService;
  private final PostService postService;
    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Like> getAllLike(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent()&& postId.isPresent()){
            return likeRepository.findByUserIdAndPostId(userId,postId);
        }else if(userId.isPresent()){
         return likeRepository.findbyUserId(userId);
        }else if(postId.isPresent()){
            return likeRepository.findByPostId(postId);
        }else
            return likeRepository.findAll();
    }

    @Override
    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);

        }


    }

