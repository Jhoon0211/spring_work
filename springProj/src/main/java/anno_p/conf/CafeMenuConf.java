package anno_p.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Configuration
public class CafeMenuConf {
	String name="아메리카노, 카페라떼, 캬라멜마끼야또";
	
	@Bean
	Americano ggul() {
		return new Americano("꿀아메리카노", 300, 200, 3800);
	}
	
	@Bean
	Cafelatte vanilla() {
		return new Cafelatte("바닐라라떼", 250, 200, 4000); 
	}
	
	Caramel caramel;
	
	@Override
	public String toString() {
		return "우리 카페의 메뉴는 " + name + " 입니다.\n";
	}
	
	
		
}

class Americano{
	String name="아메리카노";
	int coffeebean=300, water=200, price=3500;
	
	
	public Americano(String name, int coffeebean, int water, int price) {
		super();
		this.name = name;
		this.coffeebean = coffeebean;
		this.water = water;
		this.price = price;
	}

	@Override
	public String toString() {
		return "메뉴 : " + name + "\n재료 : 원두 " + coffeebean + "g, 물 " + water + "ml\n가격 : " + price + "원\n";
	}
	
	
}


class Cafelatte{
	String name="카페라떼";
	int coffeebean=250, milk=250, price=4000;

	
	public Cafelatte(String name, int coffeebean, int milk, int price) {
		super();
		this.name = name;
		this.coffeebean = coffeebean;
		this.milk = milk;
		this.price = price;
	}


	@Override
	public String toString() {
		return "메뉴 : " + name + "\n재료 : 원두 " + coffeebean + "g, 우유 " + milk + "ml\n가격 : " + price + "원\n";
	}
	
	
}


class Caramel{
	String name="캬라멜마끼야또";
	int coffeebean=220, syrup=35, milk=230, price=5000;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCoffeebean(int coffeebean) {
		this.coffeebean = coffeebean;
	}

	public void setSyrup(int syrup) {
		this.syrup = syrup;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "메뉴 : "  + name +  "\n재료 : 원두 " + coffeebean + "g, 캬라멜 시럽 " + syrup + "g, 우유 " + milk
				+ "ml \n가격 : " + price + "원\n";
	}
	
}

@Component("wondu1")
class Wondu1{
	String name="산미";

	@Override
	public String toString() {
		return name + "원두를 선택하셨습니다.";
	}
		
}

@Component("wondu2")

class Wondu2 extends Wondu1{
	String name="고소";

	@Override
	public String toString() {
		return  name + "원두를 선택하셨습니다.";
	}
		
}