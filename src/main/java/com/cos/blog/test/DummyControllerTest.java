package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
@RestController
public class DummyControllerTest {

    @Autowired
    // Spring이 관리하는 Singleton 패턴의 UserRepository 객체가 있다면 userRepository에 DI(의존성 주입) 해줌
    // => 스프링 어플리케이션 시작과 동시에 컴포넌트 스캔, JpaRepository의 상속을 받은 UserRepository는 Bean으로 등록되어 비로 Autowire 가능
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user){
        log.info(user.getUsername());
        log.info(user.getPassword());
        log.info(user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료";
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // user/{id}가 없을떄 null을 반환하는 문제가 생길떄를 대비해 Optional 객체를 반환받음
        //findById(id).get(): null을 반환할 가능성이 0인 경우 사용. 무조건 User 객체 반환
        //findById(id).orElseGet(new Supplier<User>(){  @Override get() }): null을 반환할 가능성이 있을 경우 사용. null일시 오버라이딩된 메소드 실행, User객체 반환
        //findById(id).orElseThrow(new Supplier<IllegalArgumentException>(){ @Override get() }: null을 반환할 가능성이 있을 경우 사용. null일시 오버라이딩된 메소드 실행, 에러객체 반환
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("no user found such as id: "+id));

        //웹브라우저가 호출을 하는 대상이므로, User 자바 오브젝트를 JSON 오브젝트로 변환해야함
        //스프링부트는 응답시에 MessageConverter가 자동으로 작동함
        //자바오브젝트를 반환하게 되면, MessageConverter가 Jackson 라이브러리를 호출해서 User 오브젝트를 JSON으로 변환해 응답해준다
       return user;
    }

    @GetMapping("dummy/user/all")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping("dummy/user")
    public List<User> pageList(@PageableDefault(size=2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        List<User> users = userRepository.findAll(pageable).getContent();
        return users;
    }


    //save 함수는 id를 전달하지 않으면 INSERT 해주고
    //id를 전달하면 해당 id에 대한 데이터가 있으면 UPDATE 해주고
    //해당 id에 대한 데이터가 없으면 INSERT 해준다
    @Transactional // 함수 종료시 자동 커밋
    @PutMapping("dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        log.info(Integer.toString(id));
        log.info(requestUser.getPassword());
        log.info(requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("no user such as id: "+id));
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
        //userRepository.save(user);
        return user;
    }// 더티체킹

    @DeleteMapping("dummy/user/{id}")
    public String deleteUser(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            return "no user such as id: "+id;
        }
        return "deleted user id: "+id;
    }

}
