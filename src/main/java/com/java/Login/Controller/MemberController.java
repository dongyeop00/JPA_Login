package com.java.Login.Controller;

import com.java.Login.Dto.MemberDTO;
import com.java.Login.Service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    //Controller가 Service의 자원을 사용하게 만듦 , 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/Login/save")
    public String saveForm(){
        return "save"; // templates 폴더의 save.html을 찾아간다.
    }


    //@ModelAttribute : MemberDTO의 멤버값이 html의 name값과 동일하다면 값 받아옴
    @PostMapping("/Login/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);

        return "login";
    }

    @PostMapping("/Login/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        System.out.println("memberDTO = " + memberDTO);
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null){ //login 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail()); //세션에 이메일 정보 넣어주기
            return "success";
        }
        else{ //login 실패
            return "login";
        }
    }

    @GetMapping("/Login/login")
    public String loginForm(){
        return "login";
    }
}
