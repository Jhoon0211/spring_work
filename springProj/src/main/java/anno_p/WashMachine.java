package anno_p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WashMachine {
	@Autowired
	@Qualifier("mmm2")  // 꼭 메서드가 아닌 멤버변수에 걸어도 됨
	Motor mt;
	Drum dr;
	String name;
	
	// set이 없어도 멤버변수에 @Qualifier 가 걸려있다면 자동으로 인식 
	// public void setMqaz(Motor mt) {
	//	 this.mt = mt;
	// }
	
	// 있으면 결합하고 없으면 오류나지마 == 예외처리
	@Autowired(required=false)
	public void setDr(Drum dr) {
		this.dr = dr;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "WashMachine [name=" + name + ", mt=" + mt + ", dr=" + dr + "]";
	}
	
}

class Motor{
	String name;
	int power;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Motor [name=" + name + ", power=" + power + "]";
	}
	
	
}

class Drum{
	String name;
	int size;
	public void setName(String name) {
		this.name = name;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Drum [name=" + name + ", size=" + size + "]";
	}
	
}
