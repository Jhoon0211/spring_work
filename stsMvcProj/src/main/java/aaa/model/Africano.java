package aaa.model;

import lombok.Data;

@Data
public class Africano {
	String name;
	int price, cnt, total;
	
	public int ameTotal(){
		total = price * cnt;
		return total;
	}
}
