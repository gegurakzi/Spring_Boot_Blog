package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        log.info(user.toString());

        int result = userService.signUp(user);
       return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
    }

    /*
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
        log.info(user.toString());

        User principal = userService.signIn(user); // principal: 접근주체를 뜻함

        if(principal != null){
            session.setAttribute("principal", principal);
        } else { }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    */

}
