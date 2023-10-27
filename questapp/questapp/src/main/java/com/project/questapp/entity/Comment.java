package com.project.questapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long postId;

    private Long userId;
    @Lob
    @Column(columnDefinition = "text")
    private String text;

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
    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
}
