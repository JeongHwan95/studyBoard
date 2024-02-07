package com.example.poststudy.controller;

import com.example.poststudy.dto.RequestPostDTO;
import com.example.poststudy.entity.User;
import com.example.poststudy.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /*
       회원가입 - 김정환 - 2024-02-06-16-30
    */
    @GetMapping("/get")
    public String getUser(){

        return "join";
    }


    @PostMapping("/post")
    public String postUser(@ModelAttribute RequestPostDTO requestDTO, Model model){

//        System.out.println(requestDTO.getId() + ", " + requestDTO.getEmail() + ", " + requestDTO.getPassword() +", " + requestDTO.getName());
        boolean value = service.postUser(requestDTO);

        if(value){

            return "login";
        }else{
            model.addAttribute("value", "false");
            return "join";
        }

    }

    //----------------------------------------------------------------------------------------------

    /*
     로그인 - 김제은 - 2024-02-06-17-30
     */
    @GetMapping("/login")
    public String writePost(){
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password, HttpSession session) throws Exception {

        User loginUser = service.login(id, password);
        session.setAttribute("user", loginUser);
        log.info("로그인 성공, 이름 = {}", loginUser.getName());

        return "redirect:/post/home";

    }

    //----------------------------------------------------------------------------------------------

    /*
        회원 탈퇴 - 김제은 - 2024-02-06-17-30
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> userDelete(HttpSession session){
        User user = (User) session.getAttribute("user");
        service.userDelete(user.getId());

        session.removeAttribute("user");
        log.info("회원탈퇴 성공");

        return ResponseEntity.ok("탈퇴 성공");
    }



}
