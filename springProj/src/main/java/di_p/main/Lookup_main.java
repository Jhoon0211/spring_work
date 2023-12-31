package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.CoffeeShop;
import di_p.Coffee;

public class Lookup_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/lookup.xml");
		
		CoffeeShop cs = context.getBean("cs",CoffeeShop.class);
		
		// 되는거
		System.out.println("order_am : " + cs.order_am());
		
		System.out.println("order_piano : " + cs.order_piano());
		
		System.out.println("order_hunter : " + cs.order_hunter());
		// 안되는거
		// 리턴형이 다른 메소드는 lookup-method 불가 
		System.out.println("order_tea : " +cs.order_tea());
		
		//System.out.println("order_private : " +cs.order_private()); private 접근불가
		System.out.println("order_private2 : " +cs.order_private2());
		
		// private, final, static ==> look-up method 적용되지 않고 클래스에 정의된 메소드가 호출
		System.out.println("order_final : " + cs.order_final());
		
		System.out.println("order_static : " + cs.order_static());
		
		// 추상메소드를 lookup-method로 재정의하여 실행 가능
		System.out.println("order_latte : " + cs.order_latte());
		
		 
		//cs.order_void();
		// System.out.println("order_void : " +cs.order_void()); - void는 리턴이 없으므로 안됨
		
		
		//Coffee co = context.getBean("co",Coffee.class);
		//System.out.println("co : " + co);
	}
}
