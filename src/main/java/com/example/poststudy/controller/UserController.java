package com.example.poststudy.controller;

import com.example.poststudy.dto.RequestPostDTO;
import com.example.poststudy.repository.UserRepository;
import com.example.poststudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public String getUser(){

        return "PostUser.html";
    }


    @PostMapping("/post")
    @ResponseBody
    public boolean postUser(@ModelAttribute RequestPostDTO requestDTO){

//        System.out.println(requestDTO.getId() + ", " + requestDTO.getEmail() + ", " + requestDTO.getPassword() +", " + requestDTO.getName());
        return service.postUser(requestDTO);


    }
}
