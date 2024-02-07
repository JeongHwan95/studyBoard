package com.example.poststudy.controller;

import com.example.poststudy.dto.RequestRewriteDTO;
import com.example.poststudy.entity.Post;
import com.example.poststudy.entity.User;
import com.example.poststudy.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return "redirect:/post/home";
    }
    //----------------------------------------------------------------

    /*
     게시글 전체 조회 - 정환 2024-02-07-10-54
     */
    @GetMapping("/home")
    public String home(Model model){
        List<Post> posts = this.postService.readAllPost();
        log.info("posts = {} ", posts);
        model.addAttribute("posts", posts);


        return "/home";
    }

    /*
    게시글 일부 조회 - 정환 2024-02-07
     */
    @GetMapping("/click")
    public String clickPost(@RequestParam Long postId, Model model){

        Post post = this.postService.clickPost(postId);

        model.addAttribute("post", post);


        return "read";
    }
    /*
    게시글 수정 - 정환
    */
    @GetMapping("/write/{postId}")
    public String rewritePost(@PathVariable("postId") Long postId, Model model, HttpSession session){
        model.addAttribute("postId", postId);
        User user = (User)session.getAttribute("user");

        boolean flag = this.postService.checkAuthor(user, postId);

        if(flag)
            return "/rewrite";
        else
            return "redirect:/post/home";

    }
    /*
    게시글 수정 - 정환
    */
    @PostMapping("/rewrite")
    public String rewritePost(@ModelAttribute RequestRewriteDTO requestDTO){
        log.info("requestDTO : {}", requestDTO);
        System.out.println(requestDTO.getPostId() +", " + requestDTO.getTitle()+", "+requestDTO.getContent());
        this.postService.rewritePost(requestDTO);

        return "redirect:/post/home";
    }


}
