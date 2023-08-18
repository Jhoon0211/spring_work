package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.OrderData;

@Controller
@RequestMapping("request/order")
public class OrderController {
	
	// get | post 방식 분리
	@GetMapping
	String orderForm() {
		return "req/orderForm";
	}
	
	// 주문 확인
	@PostMapping
	String orderReg(OrderData od) {
		System.out.println(od);
		return "req/orderReg";
	}
}
