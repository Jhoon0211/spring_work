package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.PathData;

/* localhost/board/notice/list 
   localhost/board/fnq/list 
   localhost/board/qna/list

   이걸 localhost/board/{cate}/list 이렇게 만드는 것임
   
   localhost/board/notice/list/1 
   localhost/board/fnq/list/2 
   localhost/board/qna/list/3

   이걸 localhost/board/{cate}/list{pNo} 이렇게 만드는 것임
*/


@Controller
@RequestMapping("/path/{cate}")
public class PathController {

	// 둘 중에 명시적인 것이 더 우선권을 갖는다
	// home.html에서 설정한 경로
	@RequestMapping("aaa")
	String mmm1(@PathVariable String cate) {
		System.out.println("mmm1() 실행 : " + cate);
		
		// 이동할 html 경로
		return "path/view";
	}
	
	@RequestMapping("{ser}")
	//String mmm2(@PathVariable String cate, @PathVariable String ser, @PathVariable PathData pd) {
	String mmm2(@PathVariable String cate, @PathVariable String ser) {
		//System.out.println("mmm2() 실행 : " + cate + "," + ser + "," + pd);
		System.out.println("mmm2() 실행 : " + cate + "," + ser);
		
		// 이동할 html 경로
		return "path/view";
	}
	
	// path/phone/list/1 
	@RequestMapping("list/{pNo}")
	String mmm3(@PathVariable String cate, @PathVariable int pNo) {
		System.out.println("mmm1() 실행 : " + cate + "," + pNo);
		
		// 이동할 html 경로
		return "path/view";
	}
	
	// path/phone/list/1 
	@RequestMapping("{ser}/{pNo}")
	String mmm4(@PathVariable String cate, @PathVariable int pNo,  @PathVariable String ser) {
		System.out.println("mmm1() 실행 : " + cate + "," + ser + "," + pNo);
		
		// 이동할 html 경로
		return "path/view";
	}
}
