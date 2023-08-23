package aaa.model;

import lombok.Data;

@Data
public class MenuData {
	
	// 공간 선언
	String url, txt;

	public MenuData(String url, String txt) {
		super();
		this.url = url;
		this.txt = txt;
	}
	
}
