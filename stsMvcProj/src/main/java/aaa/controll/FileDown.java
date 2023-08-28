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

	String upfile(BoardDTO dto, MultipartFile mmff) {
		System.out.println("OriginalFilename():"+dto.getMmff().getOriginalFilename());
		fileSave(dto.getMmff());
		
		return "board/list";
	}
	
	// 다운로드 - 사용하고자 하는 페이지에 fileSave() 함수 사용
	// 1) 파일이 존재하지 않으면 파일저장 하지 않을 것
	// 2) 파일명이 중복되면 aaa1, aaa2
	// 3) 이미지 파일만 업로드 할 수 있어야 함
	// 파일이 있는지 확인, 존재한다면
	void fileSave(MultipartFile mmff) {
		// 경로 설정
		String path = "C:\\green_project\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		// 저장 - 저장된 파일의 이름을 가져옴
		File ff = new File(path+"\\"+mmff.getOriginalFilename());
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			// 파일 저장
			System.out.println(mmff.getOriginalFilename());
			System.out.println(mmff.isEmpty());
			System.out.println(ff.exists());
			fos.write(mmff.getBytes());
			fos.close();
		// 예외처리 - 만약 파일이 없다면
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void fileSave2(PageData ud, BoardDTO dto, MultipartFile mmff) {
		ud.setMsg(null);
		//파일 업로드 유무 확인
		if(dto.getMmff().isEmpty()) {
			
			ud.setMsg("파일이 비었어");
			return;
		}
		
		String path = "D:\\public\\green\\2023_07\\study\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		
		int dot = dto.getMmff().getOriginalFilename().lastIndexOf(".");
		String fDomain = dto.getMmff().getOriginalFilename().substring(0, dot);
		String ext = dto.getMmff().getOriginalFilename().substring(dot);
		
		//이미지인지 확인
		if(!Pattern.matches("[.](bmp|jpg|gif|png|jpeg)", ext.toLowerCase())) {
			
			ud.setMsg("이미지 파일이 아님");
			return;
		}
		
		dto.setUpfile(fDomain+ext); 
		File mmff1 = new File(path+"\\"+dto.getUpfile());
		int cnt = 1;
		while(mmff1.exists()) {
			 
			dto.setUpfile(fDomain+"_"+cnt+ext);
			mmff1 = new File(path+"\\"+dto.getUpfile());
			cnt++;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(mmff1);
			
			fos.write(dto.getMmff().getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	void download(
			String ff, 
			HttpServletRequest request,
			HttpServletResponse response) {
		
		String path = request.getServletContext().getRealPath("up");
		path = "D:\\public\\green\\2023_07\\study\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		
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

	public void fileSave(String setUpfile) {
		// TODO Auto-generated method stub
		
	}
}

