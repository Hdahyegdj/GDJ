package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardDetailService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		long no = Long.parseLong(optNo.orElse("0"));
	
		String referer = request.getHeader("referer");  
		HttpSession session = request.getSession();
		if(referer.endsWith("list.do") && session.getAttribute("updateHit") == null) {  

			BoardDAO.getInstance().updateHit(no);

			session.setAttribute("updateHit", "done");
		}
		

		BoardDTO board = BoardDAO.getInstance().selectBoardByNo(no);
		

		 if(board == null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('조회 결과가 없습니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

		} else {
			request.setAttribute("board", board);
			return new ActionForward("board/detail.jsp", false);
		}
		
	}

}
