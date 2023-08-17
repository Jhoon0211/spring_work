package anno_p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Yogiyo {
	String name;
	
	// 술
	@Autowired
	//@Qualifier("dr1")
	//@Qualifier("dr2")
	@Qualifier("dr3")
	//@Qualifier("dr4")
	Drink drink;
	
	// 안주
	@Autowired
	//@Qualifier("ds1")
	//@Qualifier("ds2")
	//@Qualifier("ds3")
	@Qualifier("ds4")
	Dish dish;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	@Override
	public String toString() {
		return name + "입니다. \n주문하신 " + drink + dish;
	}
	
	
}

class Drink{
	String name;
	int price, bottle;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBottle(int bottle) {
		this.bottle = bottle;
	}
	
	@Override
	public String toString() {
		return name + "는(은) " + price + "원이며 " + bottle + "병 주문하셨습니다. \n";
	}
	
	
}

class Dish{
	String name;
	int price, cnt;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "주문하신 " + name + "는(은) " + price + "원이며 " + cnt + "개 주문하셨습니다.";
	}
	
	
}
