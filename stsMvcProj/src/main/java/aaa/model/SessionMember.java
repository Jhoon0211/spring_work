package aaa.model;

public class SessionMember {
    private String pid;
    private String name;
    private String pw;

    public SessionMember(String pid, String name, String pw) {
        this.pid = pid;
        this.name = name;
        this.pw = pw;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }
}
