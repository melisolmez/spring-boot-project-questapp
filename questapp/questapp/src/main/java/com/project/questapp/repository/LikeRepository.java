package com.project.questapp.repository;

import com.project.questapp.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository  extends JpaRepository<Like,Long> {

    List<Like> findLikeByUserIdAndPostId(Optional<Long> userId, Optional<Long> postId);

    List<Like> findLikeByUserId(Optional<Long> userId);

    List<Like> findLikeByPostId(Optional<Long> postId);

}
