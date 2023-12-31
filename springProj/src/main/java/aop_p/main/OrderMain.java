package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import aop_p.classes.Order;
public class OrderMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/order.xml");
		
		
		
		Order ord = context.getBean("order",Order.class);
		
		ord.soup("된장찌개", 9000);
		ord.soup("김치찌개", 8000);
		ord.dubrice("제육찌개", 7500);
		ord.dubrice("우삽겹덮밥", 10500);
		ord.dubrice("닭갈비덮밥", 9500);
		System.out.println("====================================");
		ord.orderCount();
		ord.orderMoney();

	}

}
