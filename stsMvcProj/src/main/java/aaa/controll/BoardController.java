package aaa.controll;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import aaa.model.BoardDTO;
import aaa.model.PageData;
import aaa.service.BoardMapper;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource
	FileDown filecon;
	
	@Resource
	BoardMapper mapper;

	// list
	@RequestMapping("list")
	String list(Model mm) {
		List<BoardDTO>data = mapper.list();
		System.out.println(data);
		// 메인데이터를 모델에 담아서 list로보낸다
		mm.addAttribute("mainData", data);
		return "board/list";
	}
	
	// 상세보기
	@RequestMapping("detail/{id}")
	String detail(Model mm, @PathVariable int id) {
		// 조회수 증가
		mapper.updateCount(id);
		mm.addAttribute("dto", mapper.detail(id));
		return "board/detail";
	}
	
	// 글쓰기 폼
	@GetMapping("insert")
	String insert(BoardDTO dto) {
		return "board/insertForm";
	}

	// 글쓰기 제출
	@PostMapping("insert")
	String insertReg(BoardDTO dto, PageData pd,
			MultipartFile mmff, Model mm) {
	    dto.setMmff(mmff);
		mapper.insseerr(dto);
		// 파일 저장
	    filecon.fileSave(dto.setUpfile(mmff));
		// 메시지 띄워주고
		pd.setMsg("작성되었습니다.");
		// list로 이동
		pd.setGoUrl("list");
		System.out.println(dto);
		mm.addAttribute("upfile", mmff.getOriginalFilename());
		return "board/alert";
	}
	
	// 글 삭제 폼
	@GetMapping("delete/{id}")
	String delete(BoardDTO dto, @PathVariable int id) {
		dto.setId(id);
		return "board/deleteForm";
	}
	
	// 글 삭제 제출
	@PostMapping("delete/{id}")
	String deleteReg(BoardDTO dto, PageData pd) {
 
		// 삭제 실패하면
		pd.setMsg("삭제실패");
		// 글 삭제 창으로 다시 이동
		pd.setGoUrl("/board/delete/" + dto.getId());
		
		// 삭제되는 글의 개수를 확인한다
		int cnt = mapper.delettt(dto);
		System.out.println("deleteReg : " + cnt + "개 삭제되었습니다.");
		
		// 글 삭제 성공하면
		if(cnt>0) {
			pd.setMsg("삭제되었습니다");
			pd.setGoUrl("/board/list");
		}
		
		return "board/alert";
	}
	
	// 글 수정 폼
	@GetMapping("modify/{id}")
	String modify(Model mm, @PathVariable int id) { // Model 왜 필요한가? detail정보 가져오려고
		// 일단 디테일 정보 가져와 줌
		mm.addAttribute("dto", mapper.detail(id));
		return "board/modifyForm";
	}
	
	// 글 수정 제출
	@PostMapping("modify/{id}")
	String modifyReg(BoardDTO dto, PageData pd) {
		

		pd.setMsg("수정실패");
		pd.setGoUrl("/board/modify/"+dto.getId());
		
		int cnt = mapper.modifffy(dto);
		System.out.println("modifyReg:"+cnt);
		if(cnt>0) {
			pd.setMsg("수정되었습니다.");
			pd.setGoUrl("/board/detail/"+dto.getId());
		}

		return "board/alert";
	}
}