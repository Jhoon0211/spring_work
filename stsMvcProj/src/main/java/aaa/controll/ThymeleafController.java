package aaa.controll;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.MenuData;
import aaa.model.SeasonMain;
import aaa.service.MyProvider;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@RequestMapping("calc")
	String calc() {
		return "thyme/calc";
	}
	
	@RequestMapping("control")
	String control(Model mm) {
		mm.addAttribute("arr", new int[] {33,11,55,88,55,77});
		mm.addAttribute("pname", "장서건");
		mm.addAttribute("pid", "qqq");
		return "thyme/control";
	}
	
	@RequestMapping("lay")
	String lay(Model mm) {
		// hd_ 1 , hd_2 자유롭게 변환 가능
		mm.addAttribute("headerUrl", "hd_2");
		mm.addAttribute("pid", "aaa");
		mm.addAttribute("arr", new int[] {77,66,33,99});
		mm.addAttribute("age", 35);
		return "thyme/lalala"; // 어차피 lalala ==> total로 보내짐
	}
	
	@RequestMapping("/{season}") // @RequestMapping 대신 @GetMapping을 사용하여 더 명확하게 표현합니다.
    String lay2(@PathVariable String season, Model mm) {
        mm.addAttribute("headerUrl", "sprbody");
        mm.addAttribute("currentSeason", season); // 현재 계절 값을 뷰로 전달하기 위해 currentSeason 속성을 추가합니다.
        return "thyme/lalala2";
    }
	
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
	
	//@Resource
	//SeasonMain sm;
	
	@Resource
	MyProvider provider;
	
	@ModelAttribute("mainCt") // == mainCt로 선언했으므로 사용할때도 mainCt
	Object mainContent(
			@PathVariable String season) {
		Object res = provider.getContext().getBean("studentmain");

		return sm.getPicture(season);
	}
}
