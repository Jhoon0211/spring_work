package aaa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MemberData {
	
	String memberid, passwd, passwd_confirm, pname, gender, hint1="기억에 남는 추억의 장소는?",
	addr1, addr2, hint_answer, moblie1, moblie2, mobile3, email;

	String [] genders = {"남", "여"};
	
	
	public Map<String, String> getHints(){
		Map<String, String> res = new LinkedHashMap<>();
		// 순서대로 내보내기 위해 LinkedHashMap<>() 사용 
		
		res.put("hint1", "기억에 남는 추억의 장소는?");
		res.put("hint2","자신의 인생 좌우명은?");
		res.put("hint3","자신의 보물 제 1호는?");
		res.put("hint4","가장 기억에 남는 선생님 성함은?");
		res.put("hint5","유년시절 가장 생각나는 친구 이름은?");
		
		return res;
	}
	
	public Map<String, String> getEmails(){
		Map<String, String> res = new LinkedHashMap<>();
		// 순서대로 내보내기 위해 LinkedHashMap<>() 사용 
		
		res.put("네이버", "naver.com");
		res.put("구글", "google.com");
		res.put("다음", "daum.net");
		res.put("줌", "zum.com");
		res.put("네이트", "nate.com");

		return res;
	}
	
}
