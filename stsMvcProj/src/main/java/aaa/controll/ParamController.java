package aaa.controll;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.Americano;
import aaa.model.Coffee;
import aaa.model.OrderData;
import aaa.model.Person;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/request")
public class ParamController {
	
	@RequestMapping("param1")
	String param1(HttpServletRequest request) {
		// param없어도 에러 안남 => null로 처리
		String str = request.getParameter("id");
		str += ',' + request.getParameter("age");
		str += ',' + request.getParameter("marriage");
		System.out.println("param1:" + str);
		return "req/param";
	} // param2:aaa,45,true
	

	@RequestMapping("param2")
	String param2(String id, int age, boolean marriage) {
		// param없으면 에러 발생
		// => id에만 값이 있고 age, marriage는 불러올 파라미터 값이 없음
		String str = "param2:" + id + "," + age + "," + marriage;
		System.out.println(str);
		return "req/param";
	} // param2:bbb,34,true
	
	@RequestMapping("param3")
	String param3(
			// 변수 명을 "" 안의 내용과 일치시켜야 한다
			@RequestParam("id") String pid,
			@RequestParam("aaa") int age,
			@RequestParam("mrg") boolean marriage) {
		// param없으면 에러 발생
		// => id에만 값이 있고 age, marriage는 불러올 파라미터 값이 업음
		String str = "param3:" + pid + "," + age + "," + marriage;
		System.out.println("param3:" + pid + "," + age + "," + marriage + ",");
		return "req/param";
	}
	
	// 입력된 값이 없으면 default값 출력O
	// 입력된 값이 있으면 default값 출력X
	// required="false" ==> 에러 안나게 함, null 처리
	@RequestMapping("param4")
	String param4(
			@RequestParam(value="id", required=false) String pid,
			@RequestParam(value="aaa", defaultValue="19") int age,
			@RequestParam(value="mrg", defaultValue="false") boolean marriage) {
		System.out.println("param4:" + pid + "," + age + "," + marriage);
		return "req/param";
	}
	
	

}
