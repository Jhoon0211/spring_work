package anno_clothes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

// xml 가져오기
//@Configuration
//@ImportResource("anno_xml/clothes.xml") 
//@ComponentScan(basePackages = "anno_clothes")
public class AnnoConfig_ootd {

	@Bean
	Top tp1() {
		return new Top("등산복상의", "기능성원단");
	}
	
	@Bean
	Bottom bt1() {
		return new Bottom("등산복하의", "기능성원단");
	}
	
	@Bean
	Shoes sh1() {
		return new Shoes("코오롱스포츠등산화");
	}
	
	@Bean
	HeadWear hd1() {
		return new HeadWear("정글모", "여름용");
	}

	@Bean
	EyeWear ey1() {
		return new EyeWear("선글라스", "UV차단");
	}
	
	
	@Bean
	Clothes mountain(Top tp1, Bottom bt1, Shoes sh1, HeadWear hd1, EyeWear ey1) {
		return new Clothes("산에갑니다!", tp1, bt1, sh1, hd1, ey1);
				
	}
	
}
