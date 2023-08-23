package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.Member;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("login/")
public class LoginController {
	
	@RequestMapping("make1")
	@ResponseBody
	String make1(HttpServletResponse response) {

		System.out.println("아이디 생성");
		return "아이디생성";
	}
	
	@RequestMapping("loginForm")
	String loginForm() {
		System.out.println("로그인폼 접속");
		return "login/loginForm";
	}
	
	@RequestMapping("loginReg")
	ModelAndView loginReg(
		@CookieValue(value="pid")String pid,
		@CookieValue(value="pw") String pw) {
		if(!pid.equals(pid)) {
			System.out.println("pid값과 pw값을 가져왔습니다" +pid+pw);
		}
		ModelAndView mav = new ModelAndView("login/loginReg");
		mav.addObject("pid",pid);
		mav.addObject("pw",pw);
		return mav;
	}
	
	@RequestMapping("loginMain")
	String loginMain() {
		System.out.println("로그인폼 접속");
		return "login/loginMain";
	}
}
