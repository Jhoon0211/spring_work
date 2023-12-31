package di_p;

public class Phone {
	String name;
	Battery bat;
	Display dis;
	Kamera kam;
	
	public Phone() {
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBat(Battery bat) {
		this.bat = bat;
	}
	public void setDis(Display dis) {
		this.dis = dis;
	}
	public void setKam(Kamera kam) {
		this.kam = kam;
	}
	public Phone(String name, Battery bat, Display dis, Kamera kam) {
		super();
		this.name = name;
		this.bat = bat;
		this.dis = dis;
		this.kam = kam;
	}
	@Override
	public String toString() {
		return "폰 이름 : " + name + bat + dis + kam;
	}
	
	
	

}

class Battery{
	String name, power;

	

	public void setName(String name) {
		this.name = name;
	}



	public void setPower(String power) {
		this.power = power;
	}



	@Override
	public String toString() {
		return "\n" + name +" : "+ power;
	}
	
	
}
class Display{
	String name, size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return  "\n" + name + " : " + size ;
	}
	
	
}	

class Kamera{
	String name, pixel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPixel() {
		return pixel;
	}

	public void setPixel(String pixel) {
		this.pixel = pixel;
	}

	@Override
	public String toString() {
		return "\n" + name + " : " + pixel + "\n";
	}
	
}