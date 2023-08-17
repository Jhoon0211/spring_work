package aop_p.webToon;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Triangle {
	
	// 직각삼각형 넓이
	public int triArea(int w, int h, int triA) {
		triA = (w*h)*(w*h);
		return triA;
		
	}
	
	// 직각삼각형 둘레
	public int triRound(int w, int h, int triR) {
		triR = (w+h)*2;
		return triR;
		
	}
}
