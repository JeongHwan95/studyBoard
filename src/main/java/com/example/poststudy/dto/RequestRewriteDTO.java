package com.example.poststudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestRewriteDTO {

    private Long postId;
    private String title;
    private String content;

}
