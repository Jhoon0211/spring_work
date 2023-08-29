package aaa.model;

import lombok.Data;

@Data
public class Paging {
	
	// 게시물 출력 최대
	public int limit = 5;
	
	// 페이지 출력 최대
	public int pageLimit = 4;
	
	//int start = 0;
	public int page, start, pageStart, pageEnd, total, pageTotal;

	public void calc() {
		
		//this.total = new BoardDTO().totalCnt();
		pageTotal = total/limit;
		
		// 만약 게시글이 13.6666.... 이렇게 떨어진다면(나머지가 있다면)
		// 페이징 처리 +1
		if(total%limit>0) {
			pageTotal++;
		}

		start = (page-1)*limit;
		pageStart = (page-1)/pageLimit*pageLimit+1;
		pageEnd = pageStart + pageLimit -1;
		
		// 끝 페이지 처리 (계속 증가 안하게)
		// 만약 페이지 끝이 전체 페이지보다 크다면 페이지 끝 = 전체 페이지
		if(pageEnd > pageTotal) {
			pageEnd = pageTotal;
		}
	}
}