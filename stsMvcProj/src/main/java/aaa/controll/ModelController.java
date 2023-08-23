package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.Battery;
import aaa.model.Camera;
import aaa.model.Person;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/model")
public class ModelController {
	
	// 클래스 삽입
	@ModelAttribute // 이름은 person, ppp1과 ppp2 중 나중 설정된 것이 무엇인지 알 수 없음
	Person ppp1() {
		return new Person("yzc", "유진초이", "1111");
	}
	
	@ModelAttribute // 이름은 person, ppp1과 ppp2 중 나중 설정된 것이 무엇인지 알 수 없음
					// 이렇게 정의하지 말 것
	Person ppp2() {
		return new Person("bss", "백승수단장", "2222");
	}
	
	@ModelAttribute("per3") // per3로 나감
	// 이렇게 정의하지 말 것
	Person ppp3(int no) {
		
		Person [] res = {
			new Person("gdm", "구동매", "3333"),  // 0
			new Person("khs", "김하성", "4444"),  // 1
			new Person("gas", "고애신", "5555")}; // 2
		System.out.println("ppp3:" + no);
		return res[no];
	}
	
	// 클래스 삽입
	// @ModelAttribute == 이거 안됨 왜냐구? 멤버변수에 직접 넣을 수 없기 때문이지 ==> 근데 이게 뭔 소리지
	@Resource
	Camera cam;
	

	@Resource
	Battery bat1;
	
	// 중요!!!
	@ModelAttribute
	Camera cc1() {
		return cam;
	}
	
	@ModelAttribute
	// 나가는 건 Battery임
	// 메소드 명이 Battery의 Bean이름 
	Battery bat1() {
		return bat1;
	}
	
	// 만약 따로 받고싶다면? Model설정해서 addAttribute
	@RequestMapping("mmm1")
	String mmm1(Model mm) {
		mm.addAttribute("pp", "아이젠 소스케");
		return "model/mmm1";
	}
	
	// 똑같이 간다
	@RequestMapping("mmm2")
	String mmm2(Model mm) {
		mm.addAttribute("pp2", "내가 곧 하늘이다");
		return "model/mmm2";
	}
}
