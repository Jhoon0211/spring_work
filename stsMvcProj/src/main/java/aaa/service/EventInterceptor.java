package aaa.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class EventInterceptor implements HandlerInterceptor {
	
	// url 들어가서 내용을 실행하기 전에 실행
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
			throws Exception {
		System.out.println("preHandle 진입");
		
		Date chkDay = new Date (2023-1900,8-1,28);
		Date today = new Date();
		if(chkDay.before(today)) {
			response.sendRedirect("/event/faaail");
			return false;
		}
		
		// 진입 실패하면 여기로 보낸다 ==> forwarding이 아닌 아예 옮겨진 거임 
		return false;
		
		// return false; ==> 경로로 진입하지도 않음 "event/gogo"
	}
}
