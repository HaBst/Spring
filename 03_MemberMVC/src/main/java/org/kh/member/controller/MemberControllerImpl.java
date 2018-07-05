package org.kh.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller // 컨트롤러만 명시하는 전용 어노테이션
public class MemberControllerImpl implements MemberController{

	@Autowired
	@Qualifier(value = "memberService")
	private MemberServiceImpl memberService;
	
	
	@Override
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response) {
		// 인코딩은 web.xml의 filter에서 셋팅함
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));

		return null;
	}
	
	
	// 값 입력방법 
	@RequestMapping(value = "/login.do")
	public String selectOneMember(HttpServletRequest request,
								@RequestParam String userId,
								@RequestParam String userPw) {
		//1. 값 추출
		Member vo = new Member();
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		
		//2. 비즈니스 로직 처리
		Member m = memberService.selectOneMember(vo); // @Qualifier value값
		
		
		HttpSession session = request.getSession();
		//3. viewName 리턴
		// viewName을 처리할때 주의할점
		// viewName을 DispatcherServlet에게 돌려주고 자동으로
		// 처리되도록 만들지만! DispatcherServlet에서는
		// 처리할때 무조건 forward 방식만을 사용함
		// (sendRedirect는 사용하지 않음)
		
		if(m!=null) {
			session.setAttribute("member", m);
			return "member/loginSuccess"; // member/loginSuccess
		}else {
			return "member/lobinFailed"; //WEB-INF/views/member/loginFailed.jsp
		}
		
	}
	

	@RequestMapping(value = "/enroll.do")
	public String insertMember(Member m) {
		
		int result = memberService.insertMember(m);
		
		if(result > 0) {
			return "member/enrollSuccess";
		}else {
			return "member/enrollFail";
		}
		
	}
	
	@RequestMapping(value = "/logout.do")
	public String logoutMember(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp"; // servlet-context.xml의 viewResolver를 관여하지 않겠다
		}else {
			return "member/logoutFail";
		}

	}
	
	@RequestMapping(value = "/myInfo.do")
	public Object myInfo(HttpSession session) {
		//1. 값추출
		Member vo = (Member)session.getAttribute("member");
		//2. 비즈니스로직 처리
		Member m = memberService.selectOneMember(vo);
		
		ModelAndView view = new ModelAndView();
		if(m != null) {

			view.addObject("mem",m);
			view.setViewName("member/myPage");
			return view;
		}else {
			view.setViewName("member/pageLoadFail");
			return view;
		}
	}
	
	@RequestMapping(value = "/mUpdate.do")
	public String memberUpdate(Member vo,HttpSession session) {
		// input type의 name값이 Member필드의 변수와 같다면 자동적으로 들어간다
//		User us = new User();
		System.out.println("voId"+vo.getUserId());
		System.out.println("voPw"+vo.getUserPw());
		System.out.println("voName"+vo.getUserName());
		System.out.println("voPhone"+vo.getUserPhone());
		int result = memberService.updateMember(vo);

		if(result > 0) {
			session.setAttribute("memer", vo);
//			return "redirect:/myInfo.do";
			return "member/mUpdateSuccess";
		}else {
//			return "redirect:/myInfo.do";
			return "member/mUpdateFail";
		}
	}
	@RequestMapping(value = "/enrollPage.do")
	public String enrollPage() {
		
		return "member/enroll";
	}
	
	@RequestMapping(value = "/delete.do")
	public String deleteMember(HttpSession session) {
		String userId = ((Member)session.getAttribute("member")).getUserId();
		int result = memberService.deleteMember(userId);
		
		if(result>0) {
			session.invalidate();
			return "member/deleteSuccess";
		}else {
			return "member/deleteFail";
		}
	}
	
	@RequestMapping(value = "/memberList.do")
	public Object memberList() {
		
		ArrayList<Member> list = memberService.memberList();
		
		ModelAndView view = new ModelAndView();
		if(!list.isEmpty()) {
			view.addObject("memberList",list);
			view.setViewName("member/memberList");
			return view;
		}else {
			view.setViewName("member/memberListFail");
			return view;
		}

		

	}
	
	@RequestMapping(value = "/home.do")
	public String home() {
		return "redirect:/index.jsp";
	}

}
