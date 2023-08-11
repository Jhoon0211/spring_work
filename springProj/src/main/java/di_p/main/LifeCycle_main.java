package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.CoffeeShop;
import di_p.Coffee;

public class LifeCycle_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/lifeCycle.xml");
		System.out.println("==========================================");
		System.out.println(context.getBean("um1"));
		System.out.println("==========================================");
		System.out.println(context.getBean("um2"));
		System.out.println("==========================================");
		System.out.println(context.getBean("um3"));
		System.out.println("==========================================");
		System.out.println(context.getBean("co1"));
		System.out.println("==========================================");
		System.out.println(context.getBean("co2"));
		
		context.close(); // destroy() 실행
		
		
		
		
	}
}
