package anno_clothes;

public class Clothes {
	String name;
	Top top;
	Bottom bottom;
	Shoes shoes;
	HeadWear head;
	EyeWear eye;
	
	public Clothes(String name, Top top, Bottom bottom, Shoes shoes, HeadWear head, EyeWear eye) {
		super();
		this.name = name;
		this.top = top;
		this.bottom = bottom;
		this.shoes = shoes;
		this.head = head;
		this.eye = eye;
	}

	@Override
	public String toString() {
		return "어디가시나요? " + name + top + bottom + shoes + head + eye ;
	}
	
	
}

class Top{
	String name, fabric;

	public Top(String name, String fabric) {
		super();
		this.name = name;
		this.fabric = fabric;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFabric() {
		return fabric;
	}



	public void setFabric(String fabric) {
		this.fabric = fabric;
	}



	@Override
	public String toString() {
		return "\n상의 : " + name + ", " + fabric;
	}
	
	
	
}

class Bottom{
	String name, fabric;

	public Bottom(String name, String fabric) {
		super();
		this.name = name;
		this.fabric = fabric;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	@Override
	public String toString() {
		return "\n하의 : " + name + ", " + fabric;
	}
	
	
}

class Shoes{
	String name;

	public Shoes(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n신발 : " + name;
	}	
	
}

class HeadWear{
	String name, type;

	public HeadWear(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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

	@Override
	public String toString() {
		return "\n모자 : " + name + ", " + type;
	}	
	
}

class EyeWear{
	String name, type;

	public EyeWear(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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

	@Override
	public String toString() {
		return  "\n아이웨어 : " + name + ", " + type;
	}
}