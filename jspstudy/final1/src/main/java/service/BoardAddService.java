package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		BoardDTO board = new BoardDTO();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		board.setIp(ip);
		
		int res = BoardDAO.getInstance().insertBoard(board);
		
		return new ActionForward("board/insertPage.jsp?res=" + res, true);
		
	}

}