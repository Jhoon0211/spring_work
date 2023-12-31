package anno_p.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import anno_p.com.sub1.Mouse;
import anno_p.comabc.Monitor;
import jakarta.annotation.Resource;

@Component
public class DESKTop {
	
	@Autowired
	Bonche bc;
	
	@Resource
	Mouse mouse;
	
	// Monitor와 Monitor를 상속받은 Mnntt 모니터 두개이므로
	// 둘중 무엇을 받을것인지 값을 지정해주어야 함
	@Resource(name = "mnntt")
	Monitor mon;
	String name = "오마이피씨";
	
	@Override
	public String toString() {
		return "DESKTop [name=" + name + ", bc=" + bc + ", mouse=" + mouse + ", mon=" + mon + "]";
	}
	
	
}
