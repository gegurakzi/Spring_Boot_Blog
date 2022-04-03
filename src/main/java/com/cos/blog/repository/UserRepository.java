package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// Bean: Spring IoC 컨테이너가 관리하는 객체
// JpaRepository를 상속받으면 자동으로 Bean 등록이 됨
public interface UserRepository extends JpaRepository<User, Integer> {
    // SELECT * FROM user WHERE username = 1?;
    Optional<User> findByUsername(String username);



    // JPA 네이밍 전략
    // 밑의 메소드는 SELECT * FROM user WHERE username = ?1 AND password = ?2; 라는 쿼리를 넣어주는 메소드로 자동생성된다
    //User findByUsernameAndPassword(String username, String password);

    // 밑의 메소드 또한 동일한 기능을 함함
   //@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery=true)
    //User login(String username, String password);
}
