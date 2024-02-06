package com.example.poststudy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name="post")
@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column
    private String title;
    @Column
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne
    private User user;
}
