package di_p.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.CoffeeShop;
import di_p.Rest;
import di_p.Coffee;

public class Rest_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/restaurant.xml", "di_xml/sicdan.xml");
		
		Rest menu = context.getBean("menu",Rest.class);
		
		// 되는거
		System.out.println(menu.comeon_morning());
		System.out.println( menu.comeon_noon());
		System.out.println( menu.comeon_dinner());
	}
}
