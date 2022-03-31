package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Bean: Spring IoC 컨테이너가 관리하는 객체
// JpaRepository를 상속받으면 자동으로 Bean 등록이 됨
public interface UserRepository extends JpaRepository<User, Integer> {

}
