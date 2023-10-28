package com.project.questapp.service.like;

import com.project.questapp.entity.Post;
import com.project.questapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface {
    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public List<Post> getPostById(User userId) {
        return null;
    }
}
