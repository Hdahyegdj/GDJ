package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class BoardRemoveService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		long no = Long.parseLong(optNo.orElse("0"));
		
		int res = BoardDAO.getInstance().deleteBoard(no);
		
		return new ActionForward("board/deleteBoard.jsp?res=" + res, true);
		
	}

}