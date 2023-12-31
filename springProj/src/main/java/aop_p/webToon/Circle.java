package aop_p.webToon;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Circle {

	// 원 넓이
	public int circleArea(int r, double cirA) {
		cirA = r*r*Math.PI; 
		return (int) cirA;
		
	}
	
	// 원 둘레
	public int circleRound(int r, double cirR) {
		cirR = r*2*Math.PI;
		return (int) cirR;	
	}
}
