package anno_p.com.sub1;

import org.springframework.stereotype.Component;
// stereotype : 양방향으로 통신한다는것(스캐닝이 된다는 것)
// annotation 중 component, controller, service은 이게 다 붙음

@Component
public class Mouse {
	
	String name = "매직마우스", type="블루투스";

	@Override
	public String toString() {
		return "Mouse [name=" + name + ", type=" + type + "]";
	}

	public Mouse(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	
	
}
