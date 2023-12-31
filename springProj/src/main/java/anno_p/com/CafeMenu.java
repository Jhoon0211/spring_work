package anno_p.com;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class CafeMenu {
	String name="아메리카노, 카페라떼, 캬라멜마끼야또";
	
	@Resource
	Americano americano;
	@Resource
	Cafelatte cafelatte;
	@Resource
	Caramel caramel;
	
	@Override
	public String toString() {
		return "우리 카페의 메뉴는 " + name + " 입니다.\n";
	}
		
}

@Component("ame")
class Americano{
	String name="아메리카노";
	int coffeebean=300, water=200, price=3500;
	@Resource(name="wondu1")
	Wondu1 won;
	
	@Override
	public String toString() {
		return "메뉴 : " + name + "\n재료 : 원두 " + coffeebean + "g, 물 " + water + "ml\n가격 : " + price + "원\n" + won + "\n";
	}
	
	
}

@Component("latte")
class Cafelatte{
	String name="카페라떼";
	int coffeebean=250, milk=250, price=4000;
	
	@Resource(name="wondu2")
	Wondu1 won;
	
	@Override
	public String toString() {
		return "메뉴 : " + name + "\n재료 : 원두 " + coffeebean + "g, 우유 " + milk + "ml\n가격 : " + price + "원\n" + won + "\n";
	}
	
	
}

@Component("maki")
class Caramel{
	String name="캬라멜마끼야또";
	int coffeebean=220, syrup=35, milk=230, price=5000;
	
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