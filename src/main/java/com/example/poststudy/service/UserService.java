package com.example.poststudy.service;

import com.example.poststudy.dto.RequestPostDTO;
import com.example.poststudy.entity.User;
import com.example.poststudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean postUser(RequestPostDTO requestDTO) {

        User user1 = repository.findUserById(requestDTO.getId());
        User user2 = repository.findUserByEmail(requestDTO.getEmail());

        if(user1 != null && user2 != null){
            return false;
        }

        User user = new User();
        user.setId(requestDTO.getId());
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        repository.save(user);

        return true;
    }
}
