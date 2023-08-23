package aaa.model;

import lombok.Data;

// 데이터만 보내는 거지 특별한 뭔가 있는 건 아님
@Data
public class Battery {
	String name;
	int size;
	
	
	public Battery(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}
	
	
}
