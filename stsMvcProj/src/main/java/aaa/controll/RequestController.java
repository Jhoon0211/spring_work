package aaa.controll;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.Person;
import aaa.model.Student;
import jakarta.servlet.http.HttpServletRequest;

// request 뿌리는 방식 세가지
// 1. ModelAndView | 2. request | 3. Model
@Controller
@RequestMapping("request")
public class RequestController {

	// ModelAndView
	// attr1 페이지 - attr2과 view 페이지는 같은 곳으로 가고 있음
	@RequestMapping("attr1")
	ModelAndView attr1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("req/attr");
		mav.addObject("age",20);
		mav.addObject("pname","정일성");
		mav.addObject("jum", new int[] {78,89,34});
		mav.addObject("now", new Date());
		mav.addObject("per", new Person("장일건", "남", false));
		return mav;
	}
	
	// request
	// attr2 페이지 - attr1과 view 페이지는 같은 곳으로 가고 있음
	@RequestMapping("attr2")
	// request 쓸 수 있다
	String attr2(HttpServletRequest request) {
		// ModelAndView의 addObject와 동일하다는것을 증명
		request.setAttribute("age",22);
		request.setAttribute("pname","정이성");
		request.setAttribute("jum", new int[] {11,22,33,44,55});
		request.setAttribute("now", new Date());
		request.setAttribute("per", new Person("장이건", "여", true));
		return "req/attr";
	}
	
	// attr3 - Model
	@RequestMapping("attr3")
	String attr3(Model mm) {
		// attribute로만 보내는 것
		mm.addAttribute("age",22);
		mm.addAttribute("pname","정삼성");
		mm.addAttribute("jum", new int[] {11,22,33,44,55});
		mm.addAttribute("now", new Date());
		mm.addAttribute("per", new Person("장삼건", "여", true));
		return "req/attr";
	}
	
	// attr4 - ModelAttribute
	@RequestMapping("attr4")
	String attr4(Model mm, 
			@ModelAttribute ("age") int age,
			@ModelAttribute ("nick") String nick,
			@ModelAttribute ("jum") int [] jum){
		
		System.out.println("age : " + age);
		System.out.println("nick : " + nick);
		System.out.println("jum : " + Arrays.toString(jum));
		// mm.addAttribute("age",22); == attr링크 설정에서 받은 age=33 으로 하겠다는 뜻
		// mm.addAttribute("pname","정사성");
		mm.addAttribute("jum", new int[] {11,22,33,44,55});
		mm.addAttribute("now", new Date());
		mm.addAttribute("per", new Person("장사건", "여", true));
		return "req/attr";
	}
	
	// attr4
	@RequestMapping("attrForm")
	String attrForm(Model mm) {
		return "req/attrForm";
	}
	
	// attrReg - bean이름처럼 들어가는 것
	@RequestMapping("attrReg")
	String attrReg( 
			@ModelAttribute("age")int age,
			@ModelAttribute ("pname") String pname,
			int [] jum,
			String gender,
			boolean mil,
			Person per) {
		
		// setter 형태로 있으면 알아서 attribute
		System.out.println("age:"+age);
		System.out.println("pname:"+pname);
		System.out.println("jum:"+Arrays.toString(jum));
		System.out.println("gender:"+gender);
		System.out.println("mil:"+mil);
		System.out.println("per:"+per);
		return "req/attrReg";
	}
	
	
	// 회원가입 입력
	@RequestMapping("joinForm")
	String joinForm(Model mm) {
		return "req/joinForm";
	}
	
	
	// 회원가입 제출
	@RequestMapping("joinReg")
	String joinReg(
			@ModelAttribute("joinid") String joinid,
			@ModelAttribute("joinemail") String joinemail,
			@ModelAttribute("joinname") String joinname,
			@ModelAttribute("joingender") String joingender,
			@ModelAttribute("joinpw") String joinpw,
			@ModelAttribute("joinbirth") int joinbirth,
			@ModelAttribute("joinphone") int joinphone) {
		return "req/joinReg";
	}
}
