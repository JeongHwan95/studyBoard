package com.example.poststudy.service;

import com.example.poststudy.dto.RequestPostDTO;
import com.example.poststudy.entity.User;
import com.example.poststudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /*
    회원 가입 - 김정환
     */
    public User postUser(RequestPostDTO requestDTO) {

        User user = new User();
        user.setId(requestDTO.getId());
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        User saveUser = repository.save(user);

        return saveUser;
    }

    /*
    회원 탈퇴 - 김제은
     */
    @Transactional
    public void userDelete(String id){
        repository.deleteById(id);
    }

    /*
    로그인 - 김제은
     */
    public User login(String id, String password){
        Optional<User> user = repository.findById(id);

        if(user.isPresent()){
            User user1 = user.get();
            if(user1.getPassword().equals(password)){
                return user1;
            } else {
                Exception exception = new Exception("비밀번호 오류");
            }
        } else {
            Exception exception = new Exception("존재하지 않는 아이디");
        }

        return user.get();
    }
}
