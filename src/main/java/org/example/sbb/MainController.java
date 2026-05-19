package org.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody //URL 요청에 대한 응답으로 리턴하는 의미
    public String index(){
         return "안녕하세요 sbb에 오신 것을 환영합니다.";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
        //question/list로 리다이렉트 해라.
        //리다이렉트란 클라이언트가 요청하면 새로운 URL로 전송하는 것
    }

}

