package aaa.model;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("dtos")
public class BoardDTOs {
	
	ArrayList<BoardDTO> arr = new ArrayList<>();
	
	String ct = "dtos 내용이여";
	int no = 3; // cnt 공통으로 적용 가능 => arr로 묶여있는 것을 for문
	
	public BoardDTOs() {
		arr =  new ArrayList<>();
		arr.add(new BoardDTO("dtos제목21", "dtos이름91", "1111", "dtos내용ㅇㄹㅇ"));
		arr.add(new BoardDTO("dtos제목31", "dtos이름81", "1111", "dtos내용ㄱㅇㄱㅎㅇ"));
		arr.add(new BoardDTO("dtos제목41", "dtos이름71", "1111", "dtos내용ㅓㅎㅇㄹㅎㅇ"));
		arr.add(new BoardDTO("dtos제목51", "dtos이름61", "1111", "dtos내용ㅇㅠㄹㅇ"));
	}
}
