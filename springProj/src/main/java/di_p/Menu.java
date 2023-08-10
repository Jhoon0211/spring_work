package di_p;

public class Menu {
	String name, main, side;
	int price;
	
	public Menu(String name, String main, String side, int price) {
		super();
		this.name = name;
		this.main = main;
		this.side = side;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + "의 메인메뉴는 " + main + ", 사이드는 " + side + "입니다. \n금액은 " + price + "원 입니다. \n맛있는 식사하세요\n";
	}
	
}
