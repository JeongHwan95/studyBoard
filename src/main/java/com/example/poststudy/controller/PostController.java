package com.example.poststudy.controller;

import com.example.poststudy.entity.Post;
import com.example.poststudy.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/write")
    public String writePost(){
        return "/write";
    }

    @PostMapping("/write")
    public String writePost(@ModelAttribute Post post){
        log.info("post = {}", post);

        postService.write(post);

        return "/home";
    }

}
