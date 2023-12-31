package aop_p.classes;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Order {
	
	ArrayList<Integer> list = new ArrayList<>();
	
	public String soup(String name, int price){
		this.list.add(price);
		return name + " " + price + "원";
	}
	
	public String dubrice(String name, int price){
		this.list.add(price);
		return name + " " + price + "원";
	}
	
	// 주문 개수 
	public String orderCount() {
		int ordcount = 0;
		for (int i=0; i<list.size(); i++) {
			ordcount++;
		}
		return ordcount + "개";
	}
	
	// 주문 합계
	public String orderMoney() {
		int totalPrice = 0;
		for (int i=0; i <list.size(); i++) {
			totalPrice += list.get(i);
			// 총 주문 합계가 10000원이 안넘으면
			}if(totalPrice<10000) {
				// 배달비 3000원 추가
				System.out.println("!!배달비 3000원 추가!!");
				totalPrice+=3000;
			}else {
				// 아니면 그냥 그 금액
				totalPrice = totalPrice;
			}
			return totalPrice + "원";
		
	}
}
