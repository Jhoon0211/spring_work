package aaa.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import aaa.model.UploadData;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping(value="upload" ,method = RequestMethod.GET)
	String fileForm() {
		return "file/uploadForm";
	}
	
	@RequestMapping(value="upload" ,method = RequestMethod.POST)
	String fileReg(
			Model mm,
			@ModelAttribute("id")String id, 
			@ModelAttribute("age")int age,
			MultipartFile ff1,
			MultipartFile ff2) {
			// 저장이 되는 건 아님
		
		System.out.println("ff1:"+ff1);
		System.out.println("ff2:"+ff2);
		System.out.println("OriginalFilename():" + ff1.getOriginalFilename());
		System.out.println("getName():" + ff1.getName());
		System.out.println("getContentType():" + ff1.getContentType());
		System.out.println("getSize():" + ff1.getSize());
		System.out.println("isEmpty():" + ff1.isEmpty());
		//OriginalFilename():
		//getName():ff1
		//getContentType():application/octet-stream
		//getSize():0
		//isEmpty():true ==> 메모리 상에서만 존재
		mm.addAttribute("ff1", ff1.getOriginalFilename());
		return "file/uploadReg";
	}
	
	// 두번째 방법
	@RequestMapping(value="upload2")
	String fileReg2(
			Model mm,
			MultipartHttpServletRequest mr) {
			// 저장이 되는 건 아님
		MultipartFile ff1 = mr.getFile("ff1");
		MultipartFile ff2 = mr.getFile("ff2");
		System.out.println("ff1:"+ff1);
		System.out.println("ff2:"+ff2);
//		System.out.println("OriginalFilename():" + ff1.getOriginalFilename());
//		System.out.println("getName():" + ff1.getName());
//		System.out.println("getContentType():" + ff1.getContentType());
//		System.out.println("getSize():" + ff1.getSize());
//		System.out.println("isEmpty():" + ff1.isEmpty());
		
		// reg페이지에 출력
		mm.addAttribute("id", mr.getParameter("id"));
		mm.addAttribute("age", mr.getParameter("age"));
		mm.addAttribute("ff1", mr.getParameter("ff1"));
		mm.addAttribute("ff1", ff1.getOriginalFilename());
		mm.addAttribute("ff2", ff2.getOriginalFilename());
		return "file/uploadReg";
	}
	
	// 세번째 방법 - UploadData 클래스 만들기
	@RequestMapping(value="upload3")
	String fileReg3(UploadData ud, HttpServletRequest request) {
		
		
		System.out.println("ud:"+ud);
		
		System.out.println("OriginalFilename():"+ud.getFf1().getOriginalFilename());
		System.out.println("getName():"+ud.getFf1().getName());
		System.out.println("getContentType():"+ud.getFf1().getContentType());
		System.out.println("getSize():"+ud.getFf1().getSize());
		System.out.println("isEmpty():"+ud.getFf1().isEmpty());
		
		fileSave(ud.getFf1());
		fileSave2(ud, request);
		
		return "file/uploadReg3";
	}
	
	// 다운로드 - 사용하고자 하는 페이지에 fileSave() 함수 사용
	// 1) 파일이 존재하지 않으면 파일저장 하지 않을 것
	// 2) 파일명이 중복되면 aaa1, aaa2
	// 3) 이미지 파일만 업로드 할 수 있어야 함
	// 파일이 있는지 확인, 존재한다면
	void fileSave(MultipartFile mf) {
		// 경로 설정
		String path = "C:\\green_project\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		// 저장 - 저장된 파일의 이름을 가져옴
		File ff = new File(path+"\\"+mf.getOriginalFilename());
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			// 파일 저장
			System.out.println(mf.getOriginalFilename());
			System.out.println(mf.isEmpty());
			System.out.println(ff.exists());
			fos.write(mf.getBytes());
			fos.close();
		// 예외처리 - 만약 파일이 없다면
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void fileSave2(UploadData ud, HttpServletRequest request) {
		ud.setMsg(null);
		//파일 업로드 유무 확인
		if(ud.getFf2().isEmpty()) {
			
			ud.setMsg("파일이 비었어");
			return;
		}
		
		String path = request.getServletContext().getRealPath("up");
		path = "D:\\public\\green\\2023_07\\study\\spring_work\\stsMvcProj\\src\\main\\webapp\\up";
		
		
		int dot = ud.getFf2().getOriginalFilename().lastIndexOf(".");
		String fDomain = ud.getFf2().getOriginalFilename().substring(0, dot);
		String ext = ud.getFf2().getOriginalFilename().substring(dot);
		
		//이미지인지 확인
		if(!Pattern.matches("[.](bmp|jpg|gif|png|jpeg)", ext.toLowerCase())) {
			
			ud.setMsg("이미지 파일이 아님");
			return;
		}
		
		ud.setFf2Name(fDomain+ext); 
		File ff = new File(path+"\\"+ud.getFf2Name());
		int cnt = 1;
		while(ff.exists()) {
			 
			ud.setFf2Name(fDomain+"_"+cnt+ext);
			ff = new File(path+"\\"+ud.getFf2Name());
			cnt++;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(ff);
			
			fos.write(ud.getFf2().getBytes());
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@RequestMapping("download")
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
}

