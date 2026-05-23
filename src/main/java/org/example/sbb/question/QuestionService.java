package org.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.example.sbb.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();// Optional<Question>에서 실제 Question 객체를 꺼내는 메서드
        }
        else {
            throw new DataNotFoundException("question not found");
        }
    }

}
