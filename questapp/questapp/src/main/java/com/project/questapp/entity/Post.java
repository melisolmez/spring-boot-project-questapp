package com.project.questapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String title;
    @Lob
    @Column(columnDefinition = "text")
    private String text;

    public Long getId(){
        return id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
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
