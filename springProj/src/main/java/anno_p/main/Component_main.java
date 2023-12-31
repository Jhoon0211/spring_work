package anno_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Component_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/component.xml");

		// bean으로 당길 시에 클래스 명이 bean이름으로 됨
		// 첫글자 대문자는 소문자로 반드시 바꿔주어야 함
		// 아직 noteBook안에 mouse가 들어가지는 않았음
		// noteBook안에 mouse잡아주려면 NoteBook.java의 Mouse클래스에 @Resource 삽입
		//System.out.println("mouse : " + context.getBean("mouse"));
		
		// 뭐든지 main에서 bean으로 부르려면 클래스에 @Component가 추가되어있어야 함
		//System.out.println("noteBook : " + context.getBean("noteBook"));
		
		// Bonche.java @Component("bbcc")
		// System.out.println("bbcc : " + context.getBean("bbcc"));

		// DESKTop 당기기
		// System.out.println("DESKTop : " + context.getBean("DESKTop"));
		
		System.out.println(context.getBean("cafeMenu"));
		System.out.println(context.getBean("ame"));
		System.out.println(context.getBean("latte"));
		System.out.println(context.getBean("maki"));
		//System.out.println(context.getBean("wondu1"));
		
		context.close();
		
				
	}

}
