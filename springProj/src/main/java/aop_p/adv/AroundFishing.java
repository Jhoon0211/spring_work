package aop_p.adv;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

// Around로 매개변수, 메서드가 무엇인지 확인 가능
// 메소드 내부를 바꿀 수는 없지만, 메소드에 들어가기 전과 후를 컨트롤 할 수 있음
public class AroundFishing {

	Object arTest(ProceedingJoinPoint joinPoint) {
		Object res = null;
		
		//System.out.println(" >> arTest 진입:"+joinPoint.toString());
		//System.out.println(" >> ShortString:"+joinPoint.toShortString());
		//System.out.println(" >> getSignature:"+joinPoint.getSignature());
		//System.out.println(" >> Signature().getName():"+joinPoint.getSignature().getName());
		//System.out.println(" >> Signature().toShortString():"+joinPoint.getSignature().toShortString());
		//System.out.println(" >> getTarget():"+joinPoint.getTarget());
		// System.out.println(" >> getArgs():"+Arrays.toString(joinPoint.getArgs()));
		//System.out.println(" >> getThis():"+joinPoint.getThis());

		try {
			
			if(joinPoint.getArgs()[0].equals("미끼없음")) {
			System.out.println("미끼를 넣으세요");
			res = "낚시를 종료합니다.";
			}
			
			res = joinPoint.proceed();
			if((int)joinPoint.getArgs()[0] < 20) {
				res = "너무 작습니다.";
			} 
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
