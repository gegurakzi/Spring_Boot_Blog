package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; //방대한 내용 또는 html 태그와 혼합되는 내용일 경우 섬머노트 라이브러리 사용

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne // 연관관계 명시 - Many: Board, One: User
    @JoinColumn(name="userId")
    private User user;// DB는 객체를 저장할 수 없지만 ORM을 사용하여 오브젝트를 저장할 수 있다.

    @CreationTimestamp
    private Timestamp createDate;
}
