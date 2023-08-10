package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.CoffeeShop;
import di_p.HandPhone;
import di_p.Phone;
import di_p.Coffee;

public class Phone_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/smartphone.xml");
		
		System.out.println( context.getBean("iphone"));
		System.out.println( context.getBean("galaxy"));

	}
}
