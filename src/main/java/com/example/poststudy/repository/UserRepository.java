package com.example.poststudy.repository;

import com.example.poststudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);
    User findUserById(String id);
}
