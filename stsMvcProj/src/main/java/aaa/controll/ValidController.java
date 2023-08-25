package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.JoinData;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class ValidController {

	@GetMapping("validation")
	String validForm(JoinData jd) {
		return "form/validForm";
	}

	// @Valid - 검사
	@PostMapping("validation")
	String validReg(@Valid JoinData jd, BindingResult br) {
		
		String[] dbid = { "aaa", "bbb", "ccc", "ddd", "eee" };
		
		for (int i = 0; i < dbid.length; i++) {
			if (jd.getPid().equals(dbid[i])) {
				System.out.println(dbid[i]);
				br.rejectValue("pid", null, "중복된 아이디입니다");
				return "form/validForm";
			}
		}
		
		System.out.println("validReg:" + br.hasErrors());
		
		// 에러 있으면 : true
		if (br.hasErrors()) {
			return "form/validForm";
		}
		// if(!jd.getPid().equals(dbid.toString()))

		// 비밀번호 == 비밀번호 확인 같은지 확인
		if (!jd.getPw1().equals(jd.getPw2())) { // 암호가 일치하지 않으면
			br.rejectValue("pw2", null, "암호확인이 문제여");
			return "form/validForm";
		}
		// 성적을 입력받아 처리하세요
		// 이름 - 한글만 2~5
		// 국영수 - 숫자 0~100

		// 에러 없으면 : false
		return "form/validReg";
	}
}
