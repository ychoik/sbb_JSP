package org.example.sbb;

import org.example.sbb.answer.Answer;
import org.example.sbb.answer.AnswerRepository;
import org.example.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired//의존성 주입 -> 스프링이 객체를 대신 생성하여 주입
    private AnswerRepository answerRepository;
    /*
   객체를 주입하는 방식에는 @Autowired외에 Setter 또는 생성자를 사용하는 방식이 있다. 순환 참조 문제와 같은 이유로 @Autowired 보다는 생성자를 통한 객체 주입 방식을 권장.
   하지만 테스트 코드에서는 JUnit이 생성자를 통한 객체 주입을 지원하지 않음.
    */
    @Test
    void testJpa() {
        Optional<Answer>oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());

    }


    //assertEquals는 테스트에서 예상한 결과와 실제 결과가 동일한지를 확인하기 위함. 즉, JPA 또는 데이터베이스에서 데이터를 올바르게 가져오는지를 확인.
    //assertEquals(기댓값, 실젯값)와 같이 작성하고 기댓값과 실젯값이 동일한지를 조사한다. 만약 기댓값과 실젯값이 동일하지 않다면 테스트는 실패로 처리
    //assertTrue()는 괄호 안의 값이 true(참) 인지를 테스트한다. oq.isPresent()가 false를 리턴하면 오류가 발생하고 테스트가 종료된다.
}
