package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardAddService;
import service.BoardDetailService;
import service.BoardEditService;
import service.BoardListService;
import service.BoardModifyService;
import service.BoardRemoveService;
import service.BoardService;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 / 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		// BoardService 객체
		BoardService service = null;
		
		// ActionForward 객체
		ActionForward af = null;
		
		// 요청에 따른 Service 선택
		switch(urlMapping) {
		// 비즈니스 로직
		case "/board/list.do":
			service = new BoardListService();
			break;
		case "/board/detail.do":
			service = new BoardDetailService();
			break;
		case "/board/add.do":
			service = new BoardAddService();
			break;
		case "/board/remove.do":
			service = new BoardRemoveService();
			break;
		case "/board/edit.do":
			service = new BoardEditService();
			break;
		case "/board/modify.do":
			service = new BoardModifyService();
			break;
		// 단순이동(포워딩(af.setRedirect(false);))
		case "/board/write.do":
			af = new ActionForward();
			af.setView("/board/write.jsp");
			af.setRedirect(false);		// false일때 생략 가능(boolean값의 기본은 false이므로 생략이 가능)
			break;
		}
		
		// 선택된 Service 실행
		try {
			if(service != null) {
				af = service.execute(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 어디로 어떻게 이동하는가?
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}