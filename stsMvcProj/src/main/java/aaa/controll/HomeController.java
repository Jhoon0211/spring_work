package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	// 서버로 키는게 아닌 
	@RequestMapping("/")
	
	// 수정하면 알아서 자기가 껐다 킴 (프로젝트 이름 옆에 devtool이 그렇게 하게 함)
	// @ResponseBody
	String homeGo() {
		System.out.println("홈이다");

		// return이 화면에 출력
		// return "String 타입이라 리턴도 homehome";
		return "home"; // views/home.html을 열어라 ==> forwarding 해주는 거임
	}
	
/*
application.yaml 설정

spring :
  thymeleaf:
    prefix : views/ # webapp에 views폴더 만들어서 home.html 생성
    suffix : .html
    cache  : false  # cashe는 날린다  

 */
}
