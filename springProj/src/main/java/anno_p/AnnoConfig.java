package anno_p;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

//@ImportResource("anno_xml/autowire.xml")

// xml파일이 따로 없어서 스캔코드 입력해주어야 함
//@ComponentScan(basePackages = "anno_p.com")
public class AnnoConfig {
	
	// 핸들
	@Bean
	BiHandle hd1() {
		return new BiHandle("일자핸들", "산악용");
	}
	
	@Bean
	BiHandle hd2() {
		return new BiHandle("3자핸들", "오인용");
	}
	
	// 휠
	@Bean
	BiWheel wh1() {
		return new BiWheel("디스크", 28);
	}
	
	@Bean
	BiWheel wh2() {
		return new BiWheel("카본", 27);
	}
	
	// 자전거
	@Bean
	BiCycle mtb(BiHandle hd1, BiWheel wh1) {
		return new BiCycle("삼천리", hd1, wh1);
				
	}
	
	@Bean
	BiCycle pb() {
		return new BiCycle("화려강산", hd2(), wh2());
				
	}
}
