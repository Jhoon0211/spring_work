package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.CoffeeShop;
import di_p.Grade;
import di_p.HambugerSet;
import di_p.Coffee;

public class Grade_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/grade.xml");
		
		
		Grade grd1 = context.getBean("grd1",Grade.class);
		System.out.println(grd1);
		System.out.println(context.getBean("red1"));
		System.out.println(context.getBean("blue1"));
		System.out.println(context.getBean("yellow1"));
		//context.close(); // destroy() 실행
		
		
		
		
	}
}
