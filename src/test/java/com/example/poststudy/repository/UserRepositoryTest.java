package com.example.poststudy.repository;

import com.example.poststudy.entity.Post;
import com.example.poststudy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    @Test
    void deleteById(){
        Post post = new Post();
        post.setTitle("제목 테스트");
        post.setContent("내용 테스트");

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Date now = new Date(currentTimestamp.getTime());
        post.setCreated(now);

        User user = new User();
        user.setId("testId");
        user.setName("jeeun");
        user.setEmail("test@gmail.com");
        user.setPassword("testPw");
        userRepository.save(user);


    }
}