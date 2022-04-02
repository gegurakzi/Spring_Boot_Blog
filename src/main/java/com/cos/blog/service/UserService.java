package com.cos.blog.service;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int signUp(User user){
        /*
        try {
            user.setRole(RoleType.USER);
            userRepository.save(user);
            return 1;
        } catch (Exception e){
            //e.printStackTrace();
            System.out.println("UserService : save() : " + e.getMessage());
        }
        return -1;
        */
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return 1;
    }

    @Transactional(readOnly = true) // Select할 떄 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성 보장)
    public User signIn(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
