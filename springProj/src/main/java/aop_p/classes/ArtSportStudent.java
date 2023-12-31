package aop_p.classes;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ArtSportStudent {
	
	ArrayList<Integer> list = new ArrayList<>();
	
	public int as1(int kor, int eng) {
		// 리턴 값
		int tot = kor+eng;
		int avg = tot/2;
		this.list.add(avg);
		
		System.out.println("국어 점수 : " + kor + " | 영어 점수 : " + eng + 
				" | 총점 : " + tot + " | 평균 : " + avg);
		return avg;
	}
	
	public int as2(int kor, int eng) {
		// 리턴 값
		int tot = kor+eng;
		int avg = tot/2;
		this.list.add(avg);
		
		System.out.println("국어 점수 : " + kor + " | 영어 점수 : " + eng + 
				" | 총점 : " + tot + " | 평균 : " + avg);
		return avg;
	}
	
	public int as3(int kor, int eng) {
		// 리턴 값
		int tot = kor+eng;
		int avg = tot/2;
		this.list.add(avg);
		
		System.out.println("국어 점수 : " + kor + " | 영어 점수 : " + eng + 
				" | 총점 : " + tot + " | 평균 : " + avg);
		return avg;
	}
	
	// 평균 합계
	public int avgSum() {
		int sum = 0;
		for (int avg : list) {
			sum += avg;
		}
		return sum;
	}
	
	// 평균의 평균
	public int avgTot() {
		int sum = 0;
		int avgAvg = 0;
		for (int avg : list) {
			sum += avg;
			avgAvg = sum/3;
		}
		return avgAvg;
	}
}
