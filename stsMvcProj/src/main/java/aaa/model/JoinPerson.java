package aaa.model;

import lombok.Data;

@Data
public class JoinPerson {
	String joinid, joinpw, joinemail, joinname, joingender;
	int joinbirth, joinphone;
		
	public JoinPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JoinPerson(String joinid, String joinemail, String joinname, String joingender, String joinpw, int joinbirth,
			int joinphone) {
		super();
		this.joinid = joinid;
		this.joinemail = joinemail;
		this.joinname = joinname;
		this.joingender = joingender;
		this.joinpw = joinpw;
		this.joinbirth = joinbirth;
		this.joinphone = joinphone;
	}
	
	
}
