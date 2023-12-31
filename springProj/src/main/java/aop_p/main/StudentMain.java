package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.classes.AdultStudent;

public class StudentMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/student.xml");
		
		AdultStudent astudent = context.getBean("adultStudent", AdultStudent.class);
		
		System.out.println("성인반 학생 1 평균 : "+ astudent.as1(80,87));		
		System.out.println("성인반 학생 2 평균 : "+ astudent.as2(89,80));
		System.out.println("성인반 학생 3 평균 : "+ astudent.as3(75,59));
		System.out.println("\n성인반 학생 평균 합계 : "+ astudent.avgSum());
		System.out.println("성인반 학생 평균의 평균 : "+ astudent.avgTot());
		System.out.println("====================================================");
			
	/*
	 
	 학생성적을 계산하세요
	 
	 과목 2 : 재직자반 (과목이 두개)
	 과목 3 : 일반	(과목이 세개)
	 과목 4 : 예체능	(과목이 네개)
	 
	 aop를 이용하여
	 1. 각 학생분류별 인원수
	 2. 평균 합계
	 3. 평균의 평균을 구하세요
	 
	 */
		
	}

}
