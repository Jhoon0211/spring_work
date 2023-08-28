package aaa.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import aaa.model.BoardDTO;

@Mapper
public interface BoardMapper {

	// 리스트
	List<BoardDTO> list();
	
	// 디테일 + 조회수 증가
	BoardDTO detail(int id);
	
	// 글쓰기
	int insseerr(BoardDTO dto);
	
	// 글삭제
	int delettt(BoardDTO dto);
	
	// 글 수정
	int modifffy(BoardDTO dto);

	// 조회수 증가
	void updateCount(int id);

	
}