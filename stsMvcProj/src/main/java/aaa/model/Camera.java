package aaa.model;

import org.springframework.stereotype.Component;

import lombok.Data;

// 공용데이터일 경우에는 이런식으로 컴포넌트를 걸면 여러 컨트롤러에서 사용 가능 
@Component
@Data
public class Camera {

	String name = "전방카메라";
	int pixel = 2080;
}