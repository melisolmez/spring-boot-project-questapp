package com.project.questapp.service.post;

import com.project.questapp.model.Post;
import com.project.questapp.model.User;
import com.project.questapp.repository.LikeRepository;
import com.project.questapp.repository.PostRepository;
import com.project.questapp.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements PostServiceInterface {

    private final PostRepository postRepository;

    private final UserService userService;
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent()){
            return postRepository.findByUserId(userId);
        }
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getOnePostById(Long postId) {
        Post existPosting=postRepository.findById(postId).orElse(null);
        if(existPosting==null){
            return null;
        }
        return postRepository.findById(postId);
    }

    @Override
    public Post savePost(Post post) {
      Optional<User> userFromDb=userService.findUserById(post.getUser().getId());
      if(userFromDb.isEmpty()){
          return null;
      }
      postRepository.save(post);
      return post;
    }

    @Override
    public boolean deletePostById(Long id) {
        Post existLike= postRepository.findById(id).orElse(null);
        if(existLike==null){
            return false;
        }
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public Post updatePostById(Long postId,Post post) {
     Optional<Post> existpost=postRepository.findById(postId);
     if(existpost.isPresent()){
         Post newPost= existpost.get();
         newPost.setText(post.getText());
         newPost.setTitle(post.getTitle());

         postRepository.save(newPost);
         return newPost;
     }
     return  null;
    }

}
