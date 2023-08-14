package anno_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Bean_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/bean.xml");

		System.out.println(context.getBean("hp920"));
		System.out.println(context.getBean("gm1"));
		System.out.println(context.getBean("nb"));
		System.out.println(context.getBean("ws1"));
		System.out.println(context.getBean("ws2"));
		
		
		context.close();		
	}
}
