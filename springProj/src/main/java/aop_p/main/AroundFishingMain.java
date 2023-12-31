package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.Fishing;

public class AroundFishingMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/fishing.xml");
		
		Fishing fsh = context.getBean("fishing",Fishing.class);
		
		System.out.println(fsh.fish("미끼없음"));
		System.out.println("---------------");
		System.out.println(fsh.miniFish(30));
		System.out.println("---------------");
		System.out.println(fsh.miniFish(10));
		System.out.println("---------------");
		System.out.println(fsh.miniFish(25));
		System.out.println("---------------");
		// System.out.println("jsk.papa:"+fsh.papa());
		//System.out.println("---------------");	
	}
	
}
