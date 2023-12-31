package di_p;

public class Grade {
	String name;
	Red red;
	Blue blue;
	Yellow yellow;
	
	public Grade() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Red getRed() {
		return red;
	}
	public void setRed(Red red) {
		this.red = red;
	}
	public Blue getBlue() {
		return blue;
	}
	public void setBlue(Blue blue) {
		this.blue = blue;
	}
	public Yellow getYellow() {
		return yellow;
	}
	public void setYellow(Yellow yellow) {
		this.yellow = yellow;
	}
	
	
	public Grade(String name, Red red, Blue blue, Yellow yellow) {
		super();
		this.name = name;
		this.red = red;
		this.blue = blue;
		this.yellow = yellow;
	}
	
	
	@Override
	public String toString() {
		return "Grade [name=" + name + ", red=" + red + ", blue=" + blue + ", yellow=" + yellow + "]";
	}
	
	
	
}

class Red{
	String name;
	int r1, r2, r3, r4, r5;
	int rtot, ravg;
	

	public void setName(String name) {
		this.name = name;
	}

	public void setR1(int r1) {
		this.r1 = r1;
	}

	public void setR2(int r2) {
		this.r2 = r2;
	}

	public void setR3(int r3) {
		this.r3 = r3;
	}

	public void setR4(int r4) {
		this.r4 = r4;
	}

	public void setR5(int r5) {
		this.r5 = r5;
	}

	public void setRtot(int rtot) {
		this.rtot = rtot;
	}

	public void setRavg(int ravg) {
		this.ravg = ravg;
	}

	public Red(String name, int r1, int r2, int r3, int r4, int r5, int rtot, int ravg) {
		super();
		this.name = name;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.r5 = r5;
		this.rtot = rtot;
		this.ravg = ravg;
		rcalc();
	}
	
	void rcalc() {
		rtot=(int)(r1+r2+r3+r4+r5);
		ravg=rtot/5;
	}
	
	@Override
	public String toString() {
		return "Red [name=" + name + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + ", r4=" + r4 + ", r5=" + r5
				+ ", rtot=" + rtot + ", ravg=" + ravg + "]";
	}
	
	
}

class Blue{
	String name;
	int b1, b2, b3, b4, b5;
	int btot, bavg;

	
	public void setName(String name) {
		this.name = name;
	}

	public void setB1(int b1) {
		this.b1 = b1;
	}

	public void setB2(int b2) {
		this.b2 = b2;
	}

	public void setB3(int b3) {
		this.b3 = b3;
	}

	public void setB4(int b4) {
		this.b4 = b4;
	}

	public void setB5(int b5) {
		this.b5 = b5;
	}

	public void setBtot(int btot) {
		this.btot = btot;
	}

	public void setBavg(int bavg) {
		this.bavg = bavg;
	}

	public Blue(String name, int b1, int b2, int b3, int b4, int b5, int btot, int bavg) {
		super();
		this.name = name;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
		this.b5 = b5;
		this.btot = btot;
		this.bavg = bavg;
		bcalc();
	}
	
	void bcalc() {
		btot=(int)(b1+b2+b3+b4+b5);
		bavg=btot/5;
	}


	@Override
	public String toString() {
		return "Blue [name=" + name + ", b1=" + b1 + ", b2=" + b2 + ", b3=" + b3 + ", b4=" + b4 + ", b5=" + b5
				+ ", btot=" + btot + ", bavg=" + bavg + "]";
	}
	
}

class Yellow{
	String name;
	int y1, y2, y3, y4, y5;
	int ytot, yavg;


	public void setName(String name) {
		this.name = name;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setY3(int y3) {
		this.y3 = y3;
	}

	public void setY4(int y4) {
		this.y4 = y4;
	}

	public void setY5(int y5) {
		this.y5 = y5;
	}

	public void setYtot(int ytot) {
		this.ytot = ytot;
	}

	public void setYavg(int yavg) {
		this.yavg = yavg;
	}

	public Yellow(String name, int y1, int y2, int y3, int y4, int y5, int ytot, int yavg) {
		super();
		this.name = name;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
		this.y5 = y5;
		this.ytot = ytot;
		this.yavg = yavg;
		ycalc();
	}
	
	void ycalc() {
		ytot=(int)(y1+y2+y3+y4+y5);
		yavg=ytot/5;
	}



	@Override
	public String toString() {
		return "Yellow [name=" + name + ", y1=" + y1 + ", y2=" + y2 + ", y3=" + y3 + ", y4=" + y4 + ", y5=" + y5
				+ ", ytot=" + ytot + ", yavg=" + yavg + "]";
	}
	
	
}