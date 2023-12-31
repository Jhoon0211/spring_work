package aop_p.webToon;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Rectangle {
	
	// 직사각형 넓이
	public String rectangleArea(int w, int h, int recA) {
		recA = w*h;
		return recA + "제곱";
		
	}
	
	// 직사각형 둘레
	public String rectangleRound(int w, int h, int recR) {
		recR = (w+h)*2;
		return recR + "cm";
		
	}
}
