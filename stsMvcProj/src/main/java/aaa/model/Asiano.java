package aaa.model;

import lombok.Data;

@Data
public class Asiano {
	String name;
	int price, cnt, total;
	
	public int ameTotal(){
		total = price * cnt;
		return total;
	}
}
