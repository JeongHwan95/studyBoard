package com.example.poststudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostService service;
    @Autowired
    PostService(PostService service){
        this.service = service;
    }

}
