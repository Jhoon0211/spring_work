package aaa.model;


import lombok.Data;

@Data
public class StudentData {
	
	String stuname, ban;
	int kor, eng, mat, total, avg;
	
	public int getTotal() {
		total = kor + eng + mat;
		return total;
	}
	
	public int getAvg() {
		avg = total / 3;
		return avg;
	}
	
	
	/*public String calcBan() {
		for (int i=0; i < ban.length(); i++) {
			if(ban[i] > ban[i+1]) {
				
			}
		}
		return ban;
	}*/
	
}

