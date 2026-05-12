package org.example.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Question {

    @Id//기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue는 해당 속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가
    //strategy = GenerationType.IDENTITY는 고유의 번호를 생성하는 방법 지정, GenerationType.IDENTITY는 해당 속성만 별도로 번호가 차례로 증가
    private Integer id;

    @Column(length = 200)//열의 세부 설정
    private String subject;

    @Column(columnDefinition = "TEXT")//열 데이터의 유형이나 성격을 정의할 때 사용한다. 즉,TEXT를 열 데이터로 넣을 수 있음을 의미, 글자 수 제한 없음
    private String content;

    private LocalDateTime createDate;

}
