package org.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이곳에 매핑을 위한 작업
		//1. 클라이언트의 요청 path 정보를 추출
		String uri = request.getRequestURI();// 전체 URI 정보를 추출
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("uri"+uri); // /member/login.do
		System.out.println("path"+path);// /login.do
		
		//2. HandlerMapping을 통해 path에 해당하는 Controller 를 검색
		Controller ctrl = handlerMapping.getController(path);
		
		//3. 검색된 Controller를 실행
		String viewName = ctrl.handleRequest(request, response);
		
		//4. 컨트로러에서 리턴한 viewName을 가지고 ViewResolver를 통해 view를 검색
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName); //.do를 포함하고 있지않다면 jsp로
		}else {
			view = viewName; //.do를 포함하고있다면 그대로 페이지 요청
		}
		
		//5. 검색한 화면으로 이동
		
		
	}

}
