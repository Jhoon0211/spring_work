package di_p.main;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import di_p.Student;

public class Student_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/student.xml");
		
		
		/*
		 * Student red = context.getBean("red",Student.class); System.out.println(red);
		 * Student blue = context.getBean("blue",Student.class);
		 * System.out.println(blue); Student yellow =
		 * context.getBean("yellow",Student.class); System.out.println(yellow);
		 */


	}
}
