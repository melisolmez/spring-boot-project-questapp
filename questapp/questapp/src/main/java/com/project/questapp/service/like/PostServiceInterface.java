package com.project.questapp.service.like;


import com.project.questapp.entity.Post;
import com.project.questapp.entity.User;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface PostServiceInterface {

    List<Post> getAllPosts();

    List<Post> getPostById(User userId);
}
