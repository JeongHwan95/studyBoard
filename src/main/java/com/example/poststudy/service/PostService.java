package com.example.poststudy.service;

import com.example.poststudy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository repository;
    @Autowired
    PostService(PostRepository repository){
        this.repository = repository;
    }

}
