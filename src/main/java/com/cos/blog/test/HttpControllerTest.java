package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;


//사용자 요청->응답(HTML파일): Controller
//사용자 요청->응답(Data): RestController

@RestController
public class HttpControllerTest {

    private static final String TAG="HttpControllerTest";

    public void lombokTest(){
        Member m = Member.builder().id(3).email("example@web.com").password("684086").username("exampler").build();
        String print1 = TAG+"getter: "+m.getUsername();
        m.setUsername("another one");
        String print2 = TAG+"setter: "+m.getUsername();
    }

    //인터넷 브라우저 요청은 무조건 GET
    @GetMapping("/test/http/get")
    public String getTest(Member m){        // query string: /test/http/get?id=1&username=admin&password=administrator&email=ssar@nate.com
        return "GET request id:"+m.getId()+", username:"+m.getUsername()+", password:"+m.getPassword()+", email:"+m.getEmail();
    }

    @PostMapping("/test/http/post") // form type: 멤버 객체에 주입해줌, raw MIME type: text/plain,  application/json
    public String postTest(@RequestBody Member m){ //JSON -> Member Object: Message Converter(스프링부트가 처리해줌)
        return "POST request id:"+m.getId()+", username:"+m.getUsername()+", password:"+m.getPassword()+", email:"+m.getEmail();
    }

    @PutMapping("/test/http/put")
    public String putTest(@RequestBody Member m){
        return "PUT request id:"+m.getId()+", username:"+m.getUsername()+", password:"+m.getPassword()+", email:"+m.getEmail();
    }

    @DeleteMapping("/test/http/delete")
    public String deleteTest(){
        return "DELETE request";
    }
}
