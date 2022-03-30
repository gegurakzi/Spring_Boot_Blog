package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM - C++, Java, Python 등 여러 언어로 만들어진 객체들을 테이블로 매핑해주는 툴

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // User 클래스를 MySQL의 row로 변환해줌
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 시퀀스, AUTO_INCREMENT

    @Column(nullable = false, length=20)
    private String username; //아이디, non-null

    @Column(nullable = false, length=60) // 해쉬를 통한 암호화 전략 -> 큰 length
    private String password;

    @Column(nullable = false, length=50)
    private String email;

    @ColumnDefault(" 'user' ")
    private String role; // Enum 사용이 좋음(admin, user, manager, ...). 차후에 Domain 관리 가능

    @CreationTimestamp
    private Timestamp createDate;

}
