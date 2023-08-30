package aaa.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import aaa.model.BoardDTO;
import aaa.model.PageData;
import aaa.model.UploadData;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;

@Data
@Component
public class FileDown {

	

	// 다운로드 - 사용하고자 하는 페이지에 fileSave() 함수 사용
	// 1) 파일이 존재하지 않으면 파일저장 하지 않을 것
	// 2) 파일명이 중복되면 aaa1, aaa2
	// 3) 이미지 파일만 업로드 할 수 있어야 함
	// 파일이 있는지 확인, 존재한다면
	
	void fileSave(BoardDTO dto, HttpServletRequest request) {
		
		//파일 업로드 유무 확인
		if(dto.getMmff().isEmpty()) {
			return;
		}
		
		String path = request.getServletContext().getRealPath("up");
		// 이건 가상서버이다, 배포 시에는 realPath로 가져온다
		path = "C:\\green_project\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";

		// 점 처리
		int dot = dto.getMmff().getOriginalFilename().lastIndexOf(".");
		// 
		String fDomain = dto.getMmff().getOriginalFilename().substring(0, dot);
		String ext = dto.getMmff().getOriginalFilename().substring(dot);

		
		dto.setUpfile(fDomain+ext); 
		File mmff = new File(path+"\\"+dto.getUpfile());
		int cnt = 1;
		
		while(mmff.exists()) {
			 
			dto.setUpfile(fDomain+"_"+cnt+ext);
			mmff = new File(path+"\\"+dto.getUpfile());
			cnt++;
		}
		
		
		
		try {
			FileOutputStream fos = new FileOutputStream(mmff);
			
			fos.write(dto.getMmff().getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	void fileDeleteModule(BoardDTO delDTO, HttpServletRequest request) {
		if(delDTO.getUpfile()!=null) {
			String path = request.getServletContext().getRealPath("up");
			path = "C:\\green_project\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
			
			new File(path+"\\"+delDTO.getUpfile()).delete();
		}
	}

}

