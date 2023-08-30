package aaa.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aaa.model.BoardDTO;


@Mapper
public interface MybatisMapper {
	// 리스트
	List<BoardDTO> list();
	
	List<BoardDTO> listSch(BoardDTO dto);
	
	List<BoardDTO> cntSch(BoardDTO dto);
	
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
