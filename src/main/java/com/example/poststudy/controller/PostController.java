package com.example.poststudy.controller;

import com.example.poststudy.entity.Post;
import com.example.poststudy.entity.User;
import com.example.poststudy.service.PostService;
import jakarta.servlet.http.HttpSession;
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

    /*
    게시글 작성 - 김제은 - 2024-02-06-16-30
     */

    @GetMapping("/write")
    public String writePost(){
        return "/write";
    }

    @PostMapping("/write")
    public String writePost(@ModelAttribute Post post, HttpSession session){
        log.info("post = {}", post);

        User user = (User) session.getAttribute("user");
        post.setUser(user);
        postService.write(post);

        return "/home";
    }
    //----------------------------------------------------------------

    @GetMapping("/home")
    public String home(){
        return "/home";
    }

}
