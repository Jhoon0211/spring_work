package di_p;

public class Coffee {
	String name;
	int price;
	
	// 설정자
	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	// 재정의 - 다형성 구현
	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + "]";
	}
	
}