package aop_p.adv;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ExecAdvice3 {

	void cirA(JoinPoint joinPoint) {
		System.out.println("ExecAdvice2 - ok:"+joinPoint.getSignature().toShortString());
	}
	
	void cirR(JoinPoint joinPoint) {
		System.out.println("ExecAdvice2 - ok:"+joinPoint.getSignature().toShortString());
	}
	
}
