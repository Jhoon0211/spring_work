package aaa.model;

import lombok.Data;

@Data //getter 넣어 줌 
//@AllArgsConstructor // 생성자 자동생성 - 보통 근데 그냥 만드는게 나음
public class Person {
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String id, int age, boolean marriage) {
		super();
		this.id = id;
		this.age= age;
		this.marriage = marriage;;
	}
	
	String id;
	int age;
	boolean marriage;
	
	
}
