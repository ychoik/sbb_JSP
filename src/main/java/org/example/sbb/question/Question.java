package org.example.sbb.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.sbb.answer.Answer;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList; //질문에서 답변을 참조하려면 question.getAnswerList() 호출하면 된다.
    //mappedBy는 참조 엔티티의 속성을 정의한다. 즉, Answer엔티티에서 Question 엔티티를 참조한 속성인 question을 mappedBy에 전달한다.
    //CascadeType.REMOVE는 질문이 삭제되면 그에 달린 답변들도 모두 삭제되도혹 하기 위함.

    //JPA는 기본적으로 @OneTOMany 관계를 LAZY, 즉 지연로딩으로 처리한다.
    //-> 질문을 조회할 때, 답변까지 한 번에 가져오지 않고, 답변 목록이 진짜 필요한 순간에 가져오겠다는 뜻
    //@Lazy와는 다름. -> 스프링 객체 생성 시점을 늦추는 것 => 필요할 떄 만듦.
}

/*
원래 엔티티에서는 Setter를 사용하지 않기를 권장한다.
엔티티는 데이터베이스와 바로 연결되므로 데이터를 자유롭게 변경할 수 있는 Setter가 안전하지 않다고 판단하기 때문에.
그럼 어떻게 Setter 없이 저장할까? -> 엔티티는 생성자에 의해서만 엔티티의 값을 저장할 수 있게 하고, 데이터를 변경해야 할 경우에는 매서드를 추가로 작성

 */
