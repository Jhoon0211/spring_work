package aaa.controll;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.BoardDTO;
import aaa.model.BoardDTOs;
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
	
	// 검색결과 : 5건
	@RequestMapping("insertList")
	@ResponseBody
	Object insertList() {
		System.out.println("insertList");
		
		ArrayList<BoardDTO> list = new ArrayList();
		
		list.add(new BoardDTO("제목1", "이름1", "1111", "내용1"));
		list.add(new BoardDTO("제목12", "이름16", "1111", "내용156"));
		list.add(new BoardDTO("제목13", "이름17", "1111", "내용355"));
		list.add(new BoardDTO("제목14", "이름18", "1111", "내용7625"));
		list.add(new BoardDTO("제목15", "이름19", "1111", "내용45326"));
		
		Object res = mapper.insseerrList(list);
		
		return res;
	}
	
	@RequestMapping("insertDTOs")
	@ResponseBody
	Object insertDTOs() {
		
		System.out.println("insertDTOs");
		
		Object res = mapper.insseerrDTOs(new BoardDTOs());
		
		return res;
	}
	
	// 여러개의 매개변수를 받아 특정 값을 설정하여 삭제
	@RequestMapping("delete")
	@ResponseBody
	Object delete(int id, String pw) {
		
		System.out.println("delete");
		
		Object res = mapper.delettt(id, pw);
		
		return res;
	}
	
	// 여러개의 매개변수를 map으로 받아 수정
	@RequestMapping("modify")
	@ResponseBody
	Object modify(int id, String pw, String pname, String content, String title) {
		
		System.out.println("modify");
		
		Object res = mapper.modifffy(id, pw, pname, content, title);
		
		return res;
	}
	
	@RequestMapping("insert")
	@ResponseBody
	Object insert(BoardDTO dto) {
		
		System.out.println("insert");
		
		Object res = mapper.insseerr(dto);
		
		res += "," + dto.getId();
		
		return res;
	}
}
