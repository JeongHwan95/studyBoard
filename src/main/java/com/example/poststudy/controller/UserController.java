package com.example.poststudy.controller;

import com.example.poststudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    UserRepository repository;
    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
}
