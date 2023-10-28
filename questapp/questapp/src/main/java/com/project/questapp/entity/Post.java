package com.project.questapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) // ilgili user o getirmene gerek yok
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)// bir user silindiğinde onunla ilgili postlarda silinecek
    @JsonIgnore
    private User user;
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
    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
    public void setUser(User user){
        this.user=user;
    }
    public User getUser(){
        return user;
    }
}
