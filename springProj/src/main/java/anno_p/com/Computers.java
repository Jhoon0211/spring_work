package anno_p.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import anno_p.com.sub1.Mouse;
import anno_p.comabc.NoteBook;

@Configuration
public class Computers {
	
	// 메소드를 이용하여 bean을 생성
	@Bean
	Mouse hp920() {
		return new Mouse("HP920","버티컬");
	}
	
	@Bean
	NoteBook gm1() {
		return new NoteBook();
	}
	
	// Bean 이름 변경
	@Bean(name="nb")
	NoteBook gm2(Bonche LG) {
		NoteBook res = new NoteBook();
		res.setName("기가바이트");
		res.setBc(LG); // 걸어놔도 안 들어옴 - NoteBook set에서 걸어줘야 함
		return res;
		
	}
	
	// 메서드로 hp920 호출
	@Bean
	WorkStation ws1() {
		// asus()는 못받아옴
		// return new WorkStation("델1", asus(), null, null, hp920()); 
		return new WorkStation("델1", null, null, null, hp920());
	}
	
	// bean 호출
	// 매개변수로 hp920 메서드 호출
	// 매개변수로 asus bean 호출
	@Bean
	WorkStation ws2(Bonche LG, Mouse hp920) {
		return new WorkStation("델2", LG, null, null, hp920);
	}
	
	
}