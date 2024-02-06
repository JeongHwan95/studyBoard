package com.example.poststudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RequestPostDTO {

    private String id;
    private String name;
    private String email;
    private String password;
}
