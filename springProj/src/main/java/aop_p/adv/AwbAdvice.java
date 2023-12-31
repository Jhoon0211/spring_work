package aop_p.adv;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AwbAdvice {

	void js(JoinPoint joinPoint) {
		System.out.println("js:"+joinPoint.getSignature().toShortString());
	}
	
	void kkbbdd(JoinPoint joinPoint) {
		System.out.println("kkbbdd:"+joinPoint.getSignature().toShortString());
	}
	
	// <aop:before method="qw" pointcut="args(qq,ww)" />
	void qw(JoinPoint joinPoint, int qq, String ww) {
		System.out.println("qw(int, String):"+joinPoint.getSignature().toShortString()+"=>"+qq+","+ww);
	}
	
	// 자료형에 따라 다르게 받아옴
	void zx(JoinPoint joinPoint, int zz, int xx) {
		System.out.println("zx(int, int):"+joinPoint.getSignature().toShortString());
	}
	
	void cos(JoinPoint joinPoint, int cc) {
		System.out.println("cos(int):"+joinPoint.getSignature().toShortString());
	}
	
	
	void oAndKang(JoinPoint joinPoint) {
		System.out.println("oAndKang:"+joinPoint.getSignature().toShortString());
	}
	
	void oOrJo(JoinPoint joinPoint) {
		System.out.println("oOrJo:"+joinPoint.getSignature().toShortString());
	}
	
	
}
