package di_p;

public class Coffee {
	String name, type;
	int price;
	
	public Coffee() {
		
	}
	
	// 설정자
	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}


	// 재정의 - 다형성 구현
	@Override
	public String toString() {
		return "Coffee [name=" + name + ", type=" + type + ", price=" + price + "]";
	}


	
}