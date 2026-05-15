package org.example.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String question, String contnet);
    List<Question> findBySubjectLike(String subject);
}

//JPA에 메서드명을 분석하여 쿼리를 만들고 실행하는 기능이 있기 때문에,
// findBy+엔티티의 속성명 과 같은 레포지터리의 메서드를 작성하면 입력한 속성의 값으로 조회 가능
