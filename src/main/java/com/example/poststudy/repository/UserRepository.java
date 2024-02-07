package com.example.poststudy.repository;

import com.example.poststudy.entity.Post;
import com.example.poststudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String id);

    void deleteById(String id);


    User findUserByEmail(String email);
    User findUserById(String id);

}
