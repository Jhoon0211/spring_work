package di_p;

public class Bicycle {
	String three, pocari, mtb;
	Wheel wheel;
	Handle handle;
	Basket basket;
	
	public String getThree() {
		return three;
	}
	public void setThree(String three) {
		this.three = three;
	}
	public String getPocari() {
		return pocari;
	}
	public void setPocari(String pocari) {
		this.pocari = pocari;
	}
	public String getMtb() {
		return mtb;
	}
	public void setMtb(String mtb) {
		this.mtb = mtb;
	}
	public Wheel getWheel() {
		return wheel;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	public Handle getHandle() {
		return handle;
	}
	public void setHandle(Handle handle) {
		this.handle = handle;
	}
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	@Override
	public String toString() {
		return "Bicycle [three=" + three + ", pocari=" + pocari + ", mtb=" + mtb + ", wheel=" + wheel + ", handle="
				+ handle + ", basket=" + basket + "]";
	}
	
	
}
