package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.Member;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MemberPasswordAdvice {

	@Pointcut("execution(* org.kh.member.model.service.*ServiceImpl.insertMember(..))")
	public void change() {}
	@Pointcut("execution(* org.kh.member.model.service.*ServiceImpl.selectOneMember(..))")
	public void login() {}
	@Pointcut("execution(int org.kh.member.model.service.*ServiceImpl.updateMember(..))")
	public void update() {}
	
	@Before("change()")
	public void changePW(JoinPoint jp)throws Exception {
		Member vo = (Member)jp.getArgs()[0];
		
		String password = new SHA256Util().encryData(vo.getUserId());
		
		System.out.println(password);
		
		vo.setUserPw(password);
		
		
	}
	@Before("login()")
	public void loginPw(JoinPoint jp) throws Exception{
		Member vo = (Member)jp.getArgs()[0];
		
		String password = new SHA256Util().encryData(vo.getUserId());
		
		System.out.println(password);
		
		vo.setUserPw(password);
	}
	@Before("update()")
	public void updatePw(JoinPoint jp) throws Exception{
		Member vo = (Member)jp.getArgs()[0];
		
		String password = new SHA256Util().encryData(vo.getUserId());
		
		System.out.println(password);
		
		vo.setUserPw(password);
	}
	
}
