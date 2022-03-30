package com.cos.blog.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TempControllerTest {

    private String TAG = "TempControllerTest Log : ";

    @GetMapping("/temp/home")
    public String tempHome(){
        log.info(TAG + "tempHome()");
        // 파일 기본경로: src/main/resources/static
        // @Controller는 경로의 파일 반환
        // @RestController는 데이터 반환
        return "/home.html";
    }

    @GetMapping("/temp/jsp")
    public String tempJSP(){
        //prefix: /WEB-INF/views/
        //suffix: .jsp
        return "test";
    }
}
