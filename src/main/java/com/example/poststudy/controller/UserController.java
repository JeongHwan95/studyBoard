package com.example.poststudy.controller;

import com.example.poststudy.dto.RequestPostDTO;
import com.example.poststudy.repository.UserRepository;
import com.example.poststudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        return "join.html";
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
}
