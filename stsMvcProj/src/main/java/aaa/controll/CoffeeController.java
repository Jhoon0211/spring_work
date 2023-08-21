package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.Americano;
import aaa.model.Coffee;

@Controller
@RequestMapping()
public class CoffeeController {
	
	@RequestMapping("coffeeForm")
	String coffeeForm(Model mm) {
		
		return "req/coffeeForm";
	}
	
	@RequestMapping("coffeeReg")
	String coffeeReg(Model mm,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="price", defaultValue="19") int price,
			@RequestParam(value="cnt", defaultValue="1") int cnt) {
		return "req/coffeeReg";
	}

	/*
	커피 주문을 구현하세요
	주문내용
	커피종류 : 필수
	잔수 : 선택 --> 없을경우 1잔 (defaultValue="1잔") String 
	
	아메리카노 : 2200원
	아프리카노 : 2300원
	아시아노 : 2500원
	
	결과 커피이름 ,잔수, 금액
	*/
}
