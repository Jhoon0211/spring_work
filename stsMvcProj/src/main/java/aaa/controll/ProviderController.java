package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.service.MyProvider;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/provider")
public class ProviderController {

	// 자동으로 갖고오기 위해
	@Resource
	MyProvider provider;
	
	@ModelAttribute("cam")
	Object mm() {
		// Component로 등록한 것은 전부 당길 수 있음
		Object res = provider.getContext().getBean("camera");
		System.out.println("mm() 진행시켜 : " + res);
		// mm() 진행시켜 : Camera(name=전방카메라, pixel=2080)
		return res;
	}
	
	@RequestMapping("list")
	String mapping1() {
		return "provider/view";
	}
	
	@RequestMapping("{bbb}")
	String mapping2(@PathVariable String bbb, Model mm) {
		mm.addAttribute("bat", provider.getContext().getBean(bbb));
		return "provider/view";
	}
}
