package di_p;

public class HandPhone {
	String name;
	Camera cam;
	
	public HandPhone() {
		System.out.println("HandPhone 기본생성자");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName():"+name);
		this.name = name;
	}

	public Camera getCam() {
		return cam;
	}

	public void setCam(Camera cam) {
		System.out.println("setCam():"+cam);
		this.cam = cam;
	}

	@Override
	public String toString() {
		return "HandPhone [name=" + name + ", cam=" + cam + "]";
	}
}


