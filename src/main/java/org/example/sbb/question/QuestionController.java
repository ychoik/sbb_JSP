package org.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/question") //공통부분
@RequiredArgsConstructor//final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할
@Controller
public class QuestionController {

    //private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    @GetMapping("/list")
    public String list(Model model){
        //findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성 -> Model 객체에 questionList라는 이름으로 저장
        //List<Question> questionList = this.questionRepository.findAll();
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")//여기서 사용된 id는 @PathVariable에 사용된 id와 이름이 동일해야 함.
    public String detail(Model model, @PathVariable("id")Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    //요청한 URL인 http://localhost:8080/question/detail/2의 숫자 2처럼 변하는 id값을 얻을 때에는 @PathVariable 애너테이션을 사용한다.
}
/*
Model 객체는 자바 클래스와 템플릿 간의 연결 고리 역할은 한다.
Model 객체에 값을 담아 두면 템플릿에서 그 값을 사용할 수 있다.
Model 객체는 따로 생성할 필요 없이 컨트롤러의 메서드에 매개변수로 지정하기만 하면 스프링 부트가 자동으로 Model 객체를 생성한다.

 */




