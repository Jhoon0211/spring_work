package di_p;

import java.util.Arrays;

public class Student {
	String name;
	int[] arr;//국영수
	int tot, avg;
	int rank=1;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public Student(String name, int[] arr) {
		super();
		this.name = name;
		this.arr = arr;
		calc();
	}
	
	
	void calc() {

		for(int i=0; i<arr.length; i++) {
			tot += arr[i];
			avg = tot/3;
		}
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", arr=" + Arrays.toString(arr) + ", tot=" + tot + ", avg=" + avg + ", rank=" + rank;
	}
	
}