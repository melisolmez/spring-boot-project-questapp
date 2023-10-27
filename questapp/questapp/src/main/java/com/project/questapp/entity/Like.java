package com.project.questapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "p_like")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long postId;
    private Long userId;

    public Long getId(){
        return id;
    }
    public void setPostId(Long postId){
        this.postId=postId;
    }
    public Long getPostId(){
        return postId;
    }
    public void setUserId(Long userId){
        this.userId=userId;
    }
    public Long getUserId(){
        return userId;
    }
}

