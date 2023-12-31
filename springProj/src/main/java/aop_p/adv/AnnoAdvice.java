package aop_p.adv;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component 가능은 하지만 용어의 편의상으로 Service 주로 사용
@Service
@Aspect
public class AnnoAdvice {

	@Before("execution(* aop_p.webToon..* (..))")
	void beforeee(JoinPoint joinPoint) {
		System.out.println("1) aop:before | "+joinPoint.getSignature().toShortString());
	}
	
	// pointcut 걸어주기
	@Pointcut("execution(* aop_p.webToon..* (..))")
	void pppiii() {}
	
	// pointcut 받아옴
	@After("pppiii()")
	//void afterrr(ProceedingJoinPoint joinPoint) {
	//ProceedingJoinPoint --> around 에서만 사용 가능
	void afterrr(JoinPoint joinPoint) {
		System.out.println("2) aop:after | "+joinPoint.getSignature().toShortString());
	}
	
	// Object qq => 리턴 값으로 처리
	@AfterReturning(pointcut = "pppiii()", returning = "qq")
	void returnnn(JoinPoint joinPoint, Object qq) {
		System.out.println("3) aop:return | "+joinPoint.getSignature().toShortString()+" ==> "+qq);
	}
	
	// 에러를 만들어야 동작 함 ==> JoSuk에서 임의로 에러 메서드 만들었음
	@AfterThrowing(pointcut = "pppiii()", throwing = "ee")
	void errrr(JoinPoint joinPoint, Throwable ee) {
		System.out.println("4) aop:error | "+joinPoint.getSignature().toShortString() + " ==> " +ee.getMessage());
	}
	
}
