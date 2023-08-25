package aaa.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.Resource;

@Configuration
public class EventConfig implements WebMvcConfigurer {

	@Resource
	EventInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.addInterceptors(registry);
		
		
		// 일단 EventInterceptor 가서 얘기하라는 뜻 임
		registry.addInterceptor(interceptor)
		.addPathPatterns("/event/gogo") // 이런식으로 검증할 페이지들 전부 추가 가능
		.addPathPatterns("/admin/**")
		.excludePathPatterns("/admin/ccc"); // 얘는 예외
		// aop는 패키지 메소드명 매개변수 그게 뭐여지만
		// interceptor는 url 기준임
	}
}
