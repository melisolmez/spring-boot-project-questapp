package com.project.questapp.service.post;


import com.project.questapp.model.Post;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface PostServiceInterface {

    List<Post> getAllPosts(Optional<Long> userId);

    Optional<Post> getOnePostById(Long postId);

    Post savePost(Post post);

    void deletePostById(Long id);

    Post updatePostById(Long id,Post post);

}
