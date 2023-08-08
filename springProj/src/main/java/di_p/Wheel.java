package di_p;

public class Wheel {
	String firstWheel, secondWheel, thirdWheel;

	public String getFirstWheel() {
		return firstWheel;
	}

	public void setFirstWheel(String firstWheel) {
		this.firstWheel = firstWheel;
	}

	public String getSecondWheel() {
		return secondWheel;
	}

	public void setSecondWheel(String secondWheel) {
		this.secondWheel = secondWheel;
	}

	public String getThirdWheel() {
		return thirdWheel;
	}

	public void setThirdWheel(String thirdWheel) {
		this.thirdWheel = thirdWheel;
	}

	@Override
	public String toString() {
		return "Wheel [firstWheel=" + firstWheel + ", secondWheel=" + secondWheel + ", thirdWheel=" + thirdWheel + "]";
	}


}
