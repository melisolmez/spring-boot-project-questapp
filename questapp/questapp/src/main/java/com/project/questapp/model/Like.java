package com.project.questapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "p_like")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) // ilgili user o getirmene gerek yok
    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)// bir user silindiğinde onunla ilgili postlarda silinecek
    @JsonIgnore
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY) // ilgili user o getirmene gerek yok
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)// bir user silindiğinde onunla ilgili postlarda silinecek
    @JsonIgnore
    private User user;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setUser(User user){
        this.user=user;
    }
    public User getUser(){
        return user;
    }
    public void setPost(Post post){
        this.post=post;
    }
    public Post getPost(){
        return post;
    }

}

