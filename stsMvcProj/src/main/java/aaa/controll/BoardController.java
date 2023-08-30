package aaa.controll;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import aaa.model.BoardDTO;
import aaa.model.PageData;
import aaa.model.Paging;
import aaa.service.BoardMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource
	FileDown filecon;
	
	@Resource
	BoardMapper mapper;

	// list
	@RequestMapping("list")
	String list(Model mm, HttpServletRequest request, @RequestParam(defaultValue = "1") int page) {
		// 페이징 처리
		Paging paging = new Paging();
		
		// 게시글 총 개수 가져오기
		paging.setTotal(mapper.totalCnt());
		paging.setPage(page);
		paging.calc(); // *

		System.out.println(paging);
		
		List<BoardDTO>data = mapper.list(paging);

		//System.out.println(data);
		// 메인데이터를 모델에 담아서 list로보낸다
		mm.addAttribute("mainData", data);
		mm.addAttribute("paging", paging);

		return "board/list";
	}
	
	// 상세보기
	@RequestMapping("detail/{id}")
	String detail(Model mm, @PathVariable int id) { // id가 @PathVariable 잡아줌 
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
	String insertReg(BoardDTO dto, PageData pd, Model mm, HttpServletRequest request) {
	    // dto.setMmff(mmff); 애초에 dto 안에 mmff가 있기때문에 또 mmff를 가져올 필요가 없었음
		// 파일 저장
	    filecon.fileSave(dto, request);
	    System.out.println("insseerr" + dto);
	    // 글쓰기
	    mapper.insseerr(dto);
		// 메시지 띄워주고
		pd.setMsg("작성되었습니다.");
		// list로 이동
		pd.setGoUrl("list");
		//System.out.println("파일명 : " + dto.getMmff().getOriginalFilename());
		//System.out.println(mmff.getOriginalFilename());
		//mm.addAttribute("upfile", mmff.getOriginalFilename());
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
	String deleteReg(BoardDTO dto, PageData pd,
			FileDown filedown,HttpServletRequest request) {
 
		// 삭제 실패하면
		pd.setMsg("삭제실패");
		// 글 삭제 창으로 다시 이동
		pd.setGoUrl("/board/delete/" + dto.getId());
		
		// 일단 여기에 디테일을 불러와야 함
		BoardDTO delDTO = mapper.detail(dto.getId());
		// 삭제되는 글의 개수를 확인한다
		int cnt = mapper.delettt(dto);
		
		// 삭제 확인
		System.out.println("deleteReg : " + cnt + "개 삭제되었습니다.");
		
		// 글 삭제 성공하면
		if(cnt>0) {
			// 이게 없으면 up폴더의 파일까지 삭제가 되지 않음
			filedown.fileDeleteModule(delDTO, request);
			pd.setMsg("삭제되었습니다");
			pd.setGoUrl("/board/list");
		}
		return "board/alert";
	}
	
	// 글 수정 폼
	@GetMapping("modify/{id}")
	String modify(BoardDTO dto, Model mm, @PathVariable int id) { // Model 왜 필요한가? detail정보 가져오려고
		// 일단 디테일 정보 가져와 줌

		mm.addAttribute("dto", mapper.detail(id));
		return "board/modifyForm";
	}
	
	// 글 수정 제출
	@PostMapping("modify/{id}")
	String modifyReg(BoardDTO dto, PageData pd,
			FileDown filedown, HttpServletRequest request) {
		

		pd.setMsg("수정실패");
		pd.setGoUrl("/board/modify/"+dto.getId());
		
		int cnt = mapper.modifffy(dto);
		System.out.println("modifyReg:"+cnt);
		if(cnt>0) {
			
			// 수정이 되었을때 파일을 저장해야 함 (파일 저장)
			filedown.fileSave(dto,request);
			mapper.modifffy(dto);
			pd.setMsg("수정되었습니다.");
			pd.setGoUrl("/board/detail/"+dto.getId());
		}

		return "board/alert";
	}
	
	// 수정폼에서 파일 삭제
	@PostMapping("fileDelete")
	String fileDelete(BoardDTO dto, PageData pd,
			FileDown filedown, HttpServletRequest request) {
		
		BoardDTO delDTO = mapper.detail(dto.getId());
		pd.setMsg("파일 삭제실패");
		// 삭제 실패하면 수정페이지로
		pd.setGoUrl("/board/modify/"+dto.getId());
		
		// 파일 삭제 mapper 추가
		int cnt = mapper.fileDelete(dto);
		System.out.println("fileDelete:"+cnt);
		if(cnt>0) {
			
			filedown.fileDeleteModule(delDTO, request);
			pd.setMsg("파일 삭제되었습니다.");
		}
		return "board/alert";
	}
	
	// 디테일에서 다운로드 처리
	@GetMapping("download/{ff}")
	void download(@PathVariable String ff, 
			HttpServletRequest request,
			HttpServletResponse response) {
		
		String path = request.getServletContext().getRealPath("up");
		path = "C:\\green_project\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		
		try {
			FileInputStream fis = new FileInputStream(path+"\\"+ff);
			String encFName = URLEncoder.encode(ff,"utf-8");
			System.out.println(ff+"->"+encFName);
			response.setHeader("Content-Disposition", "attachment;filename="+encFName);
			
			ServletOutputStream sos = response.getOutputStream();
			
			byte [] buf = new byte[1024];
			
			//int cnt = 0;
			while(fis.available()>0) { //읽을 내용이 남아 있다면
				int len = fis.read(buf);  //읽어서 -> buf 에 넣음
											//len : 넣은 byte 길이
				
				sos.write(buf, 0, len); //보낸다 :  buf의 0부터 len 만큼
				
				//cnt ++;
				//System.out.println(cnt+":"+len);
			}
			
			sos.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}