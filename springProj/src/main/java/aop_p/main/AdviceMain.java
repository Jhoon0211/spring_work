package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;

public class AdviceMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/advice.xml");
		
		
		JoSuk jsk = context.getBean("joSuk",JoSuk.class);

		System.out.println("JoSuk.dog1() 리턴 값 받아서 처리 : "+jsk.dog1(12,"아기상어"));
		System.out.println("---------------");
		
		// aop:after-throwing - errr 확인하기위한 임의 에러 메서드 호출
		jsk.nums(2);
		System.out.println("---------------");
		jsk.nums(0);
		System.out.println("---------------");
	}

}
