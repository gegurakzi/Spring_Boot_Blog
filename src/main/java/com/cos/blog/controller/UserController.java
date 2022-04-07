package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.model.OAuthProfile;
import com.cos.blog.model.OAuthToken;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

//인증이 안된 사용자들이 출입할 수 있는 경로 /auth/** , / , static 이하의 /js/**, /css/** , /image/**
//

@Controller
@Slf4j
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Value("${key.kakao.api-key}")
    private String kakao_api_key;

    @Value("${key.kakao.assigned-password}")
    private String kakao_assigned_pwd;

    @GetMapping("/auth/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm(@AuthenticationPrincipal PrincipalDetail principal){
        return "user/updateForm";
    }

    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(String code) {

        RestTemplate rt = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //key-value 형태의 오브젝트 생성(http body 구성)
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakao_api_key);
        params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
        params.add("code", code);

        //헤더와 바디를 조합하여 오브젝트 생성
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, header);

        //요청
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",  //요청을 보낼 주소
                HttpMethod.POST,                                //요청 방식
                kakaoTokenRequest,                             //HTTP 요청 정보
                String.class                                            //응답받을 형태
        );

        //JSON을 객체로 매핑한 뒤 OAuthToken 객체에 담아주기
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = new OAuthToken();
        try {
            oAuthToken = objectMapper.readValue(    // readValue시, 무조건 try-catch를 사용해야한다. 안할시 오류 발생
                    response.getBody(), OAuthToken.class
            );
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        RestTemplate rt2 = new RestTemplate();
        HttpHeaders header2 = new HttpHeaders();
        header2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        header2.add("Authorization", "Bearer " + oAuthToken.getAccess_token());


        //헤더와 바디를 조합하여 오브젝트 생성
        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(header2);

        //요청
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",  //요청을 보낼 주소
                HttpMethod.POST,                                //요청 방식
                kakaoProfileRequest,                             //HTTP 요청 정보
                String.class                                            //응답받을 형태
        );


        //JSON을 객체로 매핑한 뒤 OAuthToken 객체에 담아주기
        ObjectMapper objectMapper2 = new ObjectMapper();
        OAuthProfile oAuthProfile = new OAuthProfile();
        try {
            oAuthProfile = objectMapper2.readValue(    // readValue시, 무조건 try-catch를 사용해야한다. 안할시 오류 발생
                    response2.getBody(), OAuthProfile.class
            );
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //유저정보 생성
        User oAuthUser = User.builder().username(oAuthProfile.getProperties().getNickname()+"_"+oAuthProfile.getId())
                .password(kakao_assigned_pwd)
                .email(oAuthProfile.getKakao_account().getEmail())
                .build();

        log.info(oAuthUser.toString());

        //회원가입
        User user = userService.findUser(oAuthUser.getUsername());
        if(user == null){
            userService.signUp(oAuthUser);
        }

        //로그인
        Authentication authentication
                = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(oAuthUser.getUsername(), kakao_assigned_pwd)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/";
    }
}


