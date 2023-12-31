package di_p;

import java.util.Arrays;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements BeanNameAware, InitializingBean, DisposableBean {
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

	public void setTot(int tot) {
		this.tot = tot;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public int[] getArr() {
		return arr;
	}

	public int getTot() {
		return tot;
	}

	public int getAvg() {
		return avg;
	}

	public int getRank() {
		return rank;
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
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy()");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet()");
	}
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("=============================");
		System.out.println("setBeanName() : " + name);
	}
	

}