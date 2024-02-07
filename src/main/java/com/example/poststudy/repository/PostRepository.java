package com.example.poststudy.repository;

import com.example.poststudy.entity.Post;
import com.example.poststudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByUser(User user);
}
