package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// DB로 보낼 Board 생성
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		
		// DB로 Board 보냄(삽입)
		int result = BoardDao.getInstance().insertBoard(board);		// result 결과가 '1'이면 성공, '0'이면 실패
		
		// 이번에는 삽입 성공/실패 처리는 하지 않음
		System.out.println("삽입 결과 : " + result);
		
		// 어디로 / 어떻게   
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/list.do");	// Redirect(요청을 2번하는 거)할 때는 대부분 매핑으로 요청함   // request.getContextPath() 를 해줘야 작성완료 됨
		af.setRedirect(true);			// INSERT, UPDATE, DELETE 이후에는 Redirect 	// DB가 변경되는 작업 이후에는 Redirect(기본으로 포워딩 하지 않음)를 진행	
		return af;	
		
	}

}
