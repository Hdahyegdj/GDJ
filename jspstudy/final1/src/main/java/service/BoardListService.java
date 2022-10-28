package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import repository.BoardDAO;

public class BoardListService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("updateHit") != null) {
			session.removeAttribute("updateHit");
		}
		
		request.setAttribute("boards", BoardDAO.getInstance().selectAllBoards());
		request.setAttribute("count", BoardDAO.getInstance().selectAllBoardsCount());
		
		return new ActionForward("board/selectBoardList.jsp", false);
		
	}

}