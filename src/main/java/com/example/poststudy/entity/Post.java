package com.example.poststudy.entity;

import jakarta.persistence.*;

@Table(name="post")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    @ManyToOne
    private User user;
}
