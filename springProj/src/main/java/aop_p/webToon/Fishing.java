package aop_p.webToon;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Fishing {
	
	public String fish(String nomiggi) {
		System.out.println("낚시를 시작합니다." + nomiggi);
		return "미끼를 넣으세요";
	}
	
	public String miniFish(int centi) {
		System.out.println("낚시를 다시 시작합니다." + centi);
		return "낚시 성공 ㅋㅅㅋ";
	}
}
