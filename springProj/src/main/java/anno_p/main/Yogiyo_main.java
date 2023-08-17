package anno_p.main;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Yogiyo_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/yogiyo.xml");

		// 술판 출력
		System.out.println(context.getBean("yg1"));
		
		
		context.close();
		
	}

}
