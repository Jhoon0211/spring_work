package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.adv.ExecAdvice3;
import aop_p.webToon.Circle;
import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;
import aop_p.webToon.KangSan;
import aop_p.webToon.Rectangle;

public class FigureMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/exec.xml");
		
		
		Circle cir = context.getBean("circle",Circle.class);
		Rectangle rec = context.getBean("rectangle",Rectangle.class);

		System.out.println("원의 넓이 : "+ cir.circleArea(5, 0));
		System.out.println("---------------");
		System.out.println("원의 둘레 : "+ cir.circleRound(4, 0));
		System.out.println("---------------");
		System.out.println("직사각형의 넓이 : "+ rec.rectangleArea(5, 5, 0));
		System.out.println("---------------");
		System.out.println("직사각형의 둘레 : "+ rec.rectangleRound(7, 7, 0));
		System.out.println("---------------");
	}
	
}
