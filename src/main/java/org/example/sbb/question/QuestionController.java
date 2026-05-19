package org.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor//final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할
@Controller
public class QuestionController {

    //private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    @GetMapping("/question/list")
    public String list(Model model){
        //findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성 -> Model 객체에 questionList라는 이름으로 저장
        //List<Question> questionList = this.questionRepository.findAll();
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
/*
Model 객체는 자바 클래스와 템플릿 간의 연결 고리 역할은 한다.
Model 객체에 값을 담아 두면 템플릿에서 그 값을 사용할 수 있다.
Model 객체는 따로 생성할 필요 없이 컨트롤러의 메서드에 매개변수로 지정하기만 하면 스프링 부트가 자동으로 Model 객체를 생성한다.

 */
