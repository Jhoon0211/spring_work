package aaa.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import aaa.model.BoardDTO;
import aaa.model.Paging;

@Mapper
public interface BoardMapper {

	// 리스트
	List<BoardDTO> list(Paging paging);
	
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

	// 게시글 전체 불러오기
	int totalCnt();
	
	// 파일 삭제
	int fileDelete(BoardDTO dto);
	
	// 아이디 비밀번호 확인 (수정시)
	int idPwChk(BoardDTO dto);
}