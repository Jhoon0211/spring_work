package anno_p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Coffee {
	
	String name;
	int price, shot;
	
	@Autowired
	@Qualifier("sr1")
	Etc etc;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setShot(int shot) {
		this.shot = shot;
	}
	
	public void setEtc(Etc etc) {
		this.etc = etc;
	}
	
	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + ", shot=" + shot + etc ;
	}
	
}


class Etc{
	String name, syrup, milk, choco;
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public void setMilk(String milk) {
		this.milk = milk;
	}
	
	//@Autowired
	//@Qualifier("sr1")
	// 만약에 이렇게 넣으면 choco하나만 들어가는 것임 
	public void setChoco(String choco) {
		this.choco = choco;
	}

	@Override
	public String toString() {
		return "Etc [name=" + name + ", syrup=" + syrup + ", milk=" + milk + ", choco=" + choco + "]";
	}

	
}
