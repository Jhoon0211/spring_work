package aaa.controll;

import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.BoardDTO;
import aaa.service.MybatisMapper;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/mybatis")
public class MybatisController {
	
	@Resource
	MybatisMapper mapper;
	
	@RequestMapping("{ser}")
	@ResponseBody
	Object sqlGo(@PathVariable String ser) {
		System.out.println("ser : " + ser);
		Object res = null;
		//Object res = mapper.list();
		
		try {
//			Class cc = mapper.getClass();
//			// 메소드를 가져올 수 있따
//			Method mth = cc.getDeclaredMethod(ser);
//			res = mth.invoke(mapper);
//			
//			System.out.println(cc);
//			System.out.println("mth: " + mth);

			// ser문자열에 해당하는 메소드를 실행하는 것이다 => 지금은 list() 실행함
			System.out.println("ser : " + ser);
			res = mapper.getClass().getDeclaredMethod(ser).invoke(mapper);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 검색 기능
	@RequestMapping("listSch")
	@ResponseBody
	Object listSch(BoardDTO dto) {
		System.out.println("listSch");
		Object res = mapper.listSch(dto);
		
		return res;
	}
	
	// 등급 검색 기능
	@RequestMapping("cntSch")
	@ResponseBody
	Object cntSch(BoardDTO dto) {
		System.out.println("cntSch");
		Object res = mapper.cntSch(dto);
		
		return res;
	}
}
