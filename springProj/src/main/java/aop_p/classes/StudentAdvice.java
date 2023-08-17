package aop_p.classes;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class StudentAdvice {
	
	void adult(JoinPoint joinPoint, int kor, int eng, int tot, int avg) {
		//System.out.println("성인반 | 국어점수 : " + kor + " 영어점수 : " + eng);
	}
	
	void normal(JoinPoint joinPoint, int kor, int eng, int tot, int avg) {
		//System.out.println("성인반 | 국어점수 : " + kor + " 영어점수 : " + eng);
	}
	
	void art(JoinPoint joinPoint, int kor, int eng, int tot, int avg) {
		//System.out.println("성인반 | 국어점수 : " + kor + " 영어점수 : " + eng);
	}

}
