package aaa.model;

import lombok.Data;

@Data
public class Americano {
	String name;
	int price, cnt, total;
	
	public int ameTotal(){
		total = price * cnt;
		return total;
	}
}
