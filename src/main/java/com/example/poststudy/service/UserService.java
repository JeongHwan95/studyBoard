package com.example.poststudy.service;

import com.example.poststudy.dto.LoginDto;
import com.example.poststudy.dto.RequestPostDTO;
import com.example.poststudy.entity.Post;
import com.example.poststudy.entity.User;
import com.example.poststudy.repository.PostRepository;
import com.example.poststudy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    UserRepository repository;
    PostRepository postRepository;
    @Autowired
    public UserService(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    /*
    회원 가입 - 김정환
     */
    public boolean postUser(RequestPostDTO requestDTO) {

        User user1 = repository.findUserById(requestDTO.getId());
        User user2 = repository.findUserByEmail(requestDTO.getEmail());



        if(user1 != null || user2 != null){
            return false;
        }

        User user = new User();
        user.setId(requestDTO.getId());
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        User saveUser = repository.save(user);

        return true;
    }
    //------------------------------------------------------------------------

    /*
    회원 탈퇴 - 김제은
     */
    @Transactional
    public void userDelete(String id){
        User user = repository.findUserById(id);
        List<Post> posts = postRepository.findPostsByUser(user);

        postRepository.deleteAll(posts);
        repository.deleteById(id);
    }
    //------------------------------------------------------------------------
    /*
    로그인 - 김제은
     */
    public User login(LoginDto loginDto) throws Exception{
        log.info("login invoked. ");
        Optional<User> user = repository.findById(loginDto.getId());

        if(user.isPresent()){
            User user1 = user.get();
            if(user1.getPassword().equals(loginDto.getPassword())){
                return user1;
            } else {
                throw new Exception("비밀번호 오류");
            }
        } else {
            throw new Exception("존재하지 않는 아이디");
        }

    }


    public Page<User> findPaginated(PageRequest pageable) {

        return this.repository.findAll(pageable);
    }
    //------------------------------------------------------------------------
}
