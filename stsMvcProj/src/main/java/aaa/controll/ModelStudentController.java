package aaa.controll;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.MenuData;
import aaa.model.SeasonMain;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/model")
public class ModelStudentController {
	
	// 가져와서 mainCt에 넣어줌 ?
	@Resource
	SeasonMain sm;
	
	@ModelAttribute("hNav") // == hNav로 선언했으므로 사용할때도 hNav
	Object headerNav() {
		// MenuData에 값 입력
		ArrayList<MenuData> res = new ArrayList<>();
		res.add(new MenuData("spring", "봄"));
		res.add(new MenuData("summer", "여름"));
		res.add(new MenuData("autumn", "가을"));
		res.add(new MenuData("winter", "겨울"));
		
		// template.html [[${hNav}]] 로 보낸다 [3]
		return res;
	}
	
	@ModelAttribute("mainCt") // == mainCt로 선언했으므로 사용할때도 mainCt
	Object mainContent(
			@RequestParam(value = "sn", defaultValue = "spring") String sn) {
		
		return sm.getPicture(sn);
	}
	
	@ModelAttribute("fTxt") // == fTxt로 선언했으므로 사용할때도 fTxt
	Object footerNav() {
		
		// template.html [[${fTxt}]] 로 사용
		return "바닥글입니다.";
	}
	
	// 여긴 home.html에서 설정하는 경로, 참 어렵제? 그래두 힘내장
	@RequestMapping("/season")
	String template() {
		// 여긴 경로 model 폴더의 template.html
		return "model/template";
	}

}
