package com.example.poststudy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    @OneToMany
    private List<Post> posts;
}
