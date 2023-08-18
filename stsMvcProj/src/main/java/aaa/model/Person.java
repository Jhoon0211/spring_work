package aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //getter 넣어 줌 
//@AllArgsConstructor // 생성자 자동생성 - 보통 근데 그냥 만드는게 나음
public class Person {
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String pname, String gender, boolean mil) {
		super();
		this.pname = pname;
		this.gender = gender;
		this.mil = mil;
	}
	String pname, gender;
	boolean mil;
	
	
}
