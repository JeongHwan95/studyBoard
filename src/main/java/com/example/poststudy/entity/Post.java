package com.example.poststudy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column
    private String title;
    @Column
    private String content;

    @ManyToOne
    private User user;
}
