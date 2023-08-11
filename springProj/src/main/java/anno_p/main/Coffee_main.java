package anno_p.main;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Coffee_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/coffee.xml");

		
		System.out.println(context.getBean("bs1"));
		//System.out.println(context.getBean("ame"));
		
		context.close();
		
	}

}
