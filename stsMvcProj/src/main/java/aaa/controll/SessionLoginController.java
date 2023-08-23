package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.SessionMember;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("session")
public class SessionLoginController {

    @RequestMapping("loginReg")
    ModelAndView make1(String pid, String pw, HttpSession session) {

        String[] dbid = {"aaa", "bbb", "ccc", "ddd", "eee"};
        String[] dbpw = {"1111", "2222", "3333", "1111", "3333"};
        String[] dbPname = {"장동건", "장서건", "장동건", "장남건", "북두신건"};

        ModelAndView mav = new ModelAndView("session/loginMain");
        String msg = "로그인 실패";

        for (int i = 0; i < dbid.length; i++) {
            if (dbid[i].equals(pid) && dbpw[i].equals(pw)) {
                msg = dbPname[i] + " 로그인 성공";
                
                // 세션에 로그인 정보 저장
                SessionMember mem = new SessionMember(pid, dbPname[i], pw);
                session.setAttribute("mem", mem);
                
                mav.addObject("msg", msg);
                mav.addObject("mem", mem); // mem 객체도 함께 추가
                return mav;  // 로그인 성공 시 loginMain으로 리다이렉트
            }
        }

        mav.addObject("msg", msg);
        return new ModelAndView("redirect:/session/loginMain");
    }
    
    @RequestMapping("logout")
	ModelAndView delete(HttpSession session) {
	        
	    SessionMember mem = (SessionMember) session.getAttribute("mem");  // 로그인된 멤버 정보 가져오기
	    String pname = mem != null ? mem.getName() : "없음";  // 로그인된 멤버의 이름 가져오기
	        
	    // 세션 값 제거
	    session.removeAttribute("pid");
	    session.removeAttribute("pname");
	    session.removeAttribute("mem");  // 로그인 정보 제거

	    ModelAndView mav = new ModelAndView("session/loginAlert");
	    mav.addObject("msg", pname + " 로그아웃 되었습니다");
	    System.out.println("로그아웃이니");
	    return mav;
	}

    @RequestMapping("loginMain")
    String view(HttpSession session) {
        System.out.println("메인이니혹시");
        SessionMember mem = (SessionMember) session.getAttribute("mem");
        if (mem != null) {
            return "session/loginMain";
        } else {
            return "redirect:/session/loginReg";
        }
    }
}

