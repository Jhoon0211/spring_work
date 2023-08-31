package aaa.model;

import java.sql.Date;
import java.util.regex.Pattern;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// 이게 있으면 BoardMapper.xml에서 경로를 정확히 입력하는 것인 알리아스 명을 넣으면 됨
@Alias("bDTO")
@Data
public class BoardDTO {

	// insertForm(글쓰기)에서 파일업로드 사용하려면 이게 있어야 함
	MultipartFile mmff;
	
	int id, cnt, seq, lev, gid;
	String title, pname, pw, upfile, content;
	Date regDate;
	
	// Mybatis 검색기능 하면서 추가한거임 board랑 연관 X
	String grade;
	
	public String getUpfile() {
		if(upfile == null || upfile.trim().equals("") ||  upfile.trim().equals("null") ) {
			upfile = null;
		}
		return upfile;
	}
	
	public boolean isImg() {
		if(getUpfile()==null) {
			return false;
		}
		return Pattern.matches(".{1,}[.](bmp|png|gif|jpg|jpeg)", upfile.toLowerCase());
	}

	public BoardDTO(String title, String pname, String pw, String content) {
		super();
		this.title = title;
		this.pname = pname;
		this.pw = pw;
		this.content = content;
	}
	
	
}