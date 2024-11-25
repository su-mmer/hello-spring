package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";  // resources:templates의 hello 를 찾아서 Return
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {  // Request Parameter
        model.addAttribute("name", name);
        return "hello-template";  // 템플릿을 랜더링해서 반환
    }

    @GetMapping("hello-string")
    @ResponseBody  // HTTP 응답하는 body에 해당 내용을 직접 넣겠다!
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;  // string을 그대로 반환
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();  // json 반환 방식을 좀 더 염두에 두거라!
        hello.setName(name);
        return hello;  // 객체 반환
    }

    // property 접근 방식
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
