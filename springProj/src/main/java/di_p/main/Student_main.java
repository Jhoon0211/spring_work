package di_p.main;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import di_p.Student;

public class Student_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/student.xml");
		
		
		Student std1 = context.getBean("std1",Student.class);
		System.out.println(std1);
		Student std2 = context.getBean("std2",Student.class);
		System.out.println(std2);
		Student std3 = context.getBean("std3",Student.class);
		System.out.println(std3);
		Student std4 = context.getBean("std4",Student.class);
		System.out.println(std4);

	}
}
