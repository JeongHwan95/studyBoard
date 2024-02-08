package com.example.poststudy.service;

import com.example.poststudy.dto.RequestRewriteDTO;
import com.example.poststudy.entity.Post;
import com.example.poststudy.entity.User;
import com.example.poststudy.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    /*
    게시글 작성 - 김제은 - 2024-02-07
     */
    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }

    /*
    게시글 삭제 - 김제은 - 2024-02-077-16-30
  */
    public void write(Post post){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Date now = new Date(currentTimestamp.getTime());
        post.setCreated(now);
        Post savePost = postRepository.save(post);
    }

    /*
    게시글 전체 반환 - 김정환 - 2024-02-07-11-08
     */
    public List<Post> readAllPost(){
        List<Post> lists = postRepository.findAll();

        return lists;
    }

    /*
    게시글 하나 반환 - 김정환 - 2024-02-07-11-08
     */
    @Transactional
    public Post clickPost(Long postId) {

        Post post = this.postRepository.findById(postId).orElse(null);
        int numOfClick = post.getNumOfClick();
        post.setNumOfClick(++numOfClick);

        return post;
    }

    /*
    게시글 수정 - 김정환 - 2024-02-07-14-38
     */
    @Transactional
    public void rewritePost(RequestRewriteDTO requestDTO) {

        Post post = this.postRepository.findById(requestDTO.getPostId()).orElse(null);
        post.setTitle(requestDTO.getTitle());
        post.setContent(requestDTO.getContent());
    }
    /*
    게시글 수정시 사용자가 글과 일치하는지 확인 - 김정환 - 2024-02-07-14-38
    */
    public boolean checkAuthor(User user, Long postId) {
        Post post = this.postRepository.findById(postId).orElse(null);
        User userInWrite = post.getUser();

        if(Objects.equals(user.getUserId(), userInWrite.getUserId()))
            return true;
        else
            return false;
    }
}
