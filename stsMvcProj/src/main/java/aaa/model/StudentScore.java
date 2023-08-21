package aaa.model;

import lombok.Data;

@Data
public class StudentScore {
	
	// 국영수 점수 받아오기
	StudentData sd;
	
	int total, avg;
	
	public int getTotal() {
		total = sd.kor + sd.eng + sd.mat;
		return total;
	}
	
	public int getAvg() {
		avg = total / 3;
		return avg;
	}
}
