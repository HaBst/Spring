package org.kh.tv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.tv.model.vo.TV;
import org.kh.tv.model.vo.TVmgr;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Servlet implementation class Dependency1Servlet
 */
public class Dependency1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dependency1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// System.out.println("서블릿 정상 호출");
	
		// TV tv = (TV)BeanFactory.getBean(request.getParameter("beanName")); // 사용자에게 [samsung/lg] 입력받음
		
		
		// xml파일에서 [samsung/lg] 설정 변경
		
		// xml 파일에 있는 Bean 객체를 가져오기 위한 작업
		// 1. xml 파일을 읽어 들여야함
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/sampleContext.xml");
		TV tv = cntx.getBean("tvMgr",TVmgr.class).getTv();
		// TV tv = ((TVmgr)cntx.getBean("tvMgr")).getTv();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
