package com.project.questapp.service.like;


import com.project.questapp.controller.LikeRequest;
import com.project.questapp.model.Like;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Validated
public interface LikeServiceInterface {


    List<Like> getAllLike(Optional<Long> userId, Optional<Long> postId);

    Like getOneLikeById(Long likeId);

    Like createOneLike(Like like);

    boolean deleteLikeById(Long likeId);
}
