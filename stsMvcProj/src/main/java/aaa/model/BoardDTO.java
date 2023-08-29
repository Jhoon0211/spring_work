package aaa.model;

import java.sql.Date;

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
	
}