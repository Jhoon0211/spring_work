package aop_p.adv;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class AdviceAdvice {

	void beforeee(JoinPoint joinPoint) {
		System.out.println("1) aop:before | "+joinPoint.getSignature().toShortString());
	}
	//void afterrr(ProceedingJoinPoint joinPoint) {
	//ProceedingJoinPoint --> around 에서만 사용 가능
	void afterrr(JoinPoint joinPoint) {
		System.out.println("2) aop:after | "+joinPoint.getSignature().toShortString());
	}
	
	// Object qq => 리턴 값으로 처리
	void returnnn(JoinPoint joinPoint, Object qq) {
		System.out.println("3) aop:return | "+joinPoint.getSignature().toShortString()+" ==> "+qq);
	}
	
	// 에러를 만들어야 동작 함 ==> JoSuk에서 임의로 에러 메서드 만들었음
	void errrr(JoinPoint joinPoint, Throwable ee) {
		System.out.println("4) aop:error | "+joinPoint.getSignature().toShortString() + " ==> " +ee.getMessage());
	}
	
}
