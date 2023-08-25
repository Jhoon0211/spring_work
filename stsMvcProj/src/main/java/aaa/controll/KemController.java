package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.JoinData;
import aaa.model.KemData;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class KemController {

	@GetMapping("kem")
	String validForm(KemData kd) {
		return "form/kemForm";
	}
	
	// @Valid - 검사
	@PostMapping("kem")
	String validReg(@Valid KemData kd, BindingResult br) {
		
		System.out.println("validReg:" + br.hasErrors());
		// 에러 있으면 : true
		if(br.hasErrors()) {
			return "form/kemForm";
		}
		// 성적을 입력받아 처리하세요
		// 이름 - 한글만 2~5
		// 국영수 - 숫자 0~100
		
		
		// 에러 없으면 : false 
		return "form/kemReg";
	}
}
