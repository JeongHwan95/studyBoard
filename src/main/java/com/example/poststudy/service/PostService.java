package com.example.poststudy.service;

import com.example.poststudy.entity.Post;
import com.example.poststudy.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    /*
    게시글 작성 - 김제은 - 2024-02-06-16-30
     */
    public void write(Post post){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Date now = new Date(currentTimestamp.getTime());
        post.setCreated(now);
        Post savePost = postRepository.save(post);

    }

}
