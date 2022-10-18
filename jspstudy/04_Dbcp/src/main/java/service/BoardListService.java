package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardListService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DB에서 가져온 게시글 목록
		List<Board> boards = BoardDao.getInstance().selectAllBoards();
		
		// 게시글 목록을 Jsp로 보내기 위해서 request에 저장
		request.setAttribute("boards", boards);
		
		// 어디로 / 어떻게
		ActionForward af = new ActionForward();
		af.setView("/board/list.jsp");	// webapp/board/list.jsp
		af.setRedirect(false);	// 포워드
		return af;
		
		
		// 실행
		// 2. System.out.println(boards);   -> 실행하여 게시판 클릭하면 console 창에 "[Board(board_no=2, title=긴급공지, content=다 날아갔다, create_date=2022-10-18), Board(board_no=1, title=공지, content=불났다, create_date=2022-10-18)]"
		// 1. System.out.println("BoardListService");	->  실행하여 게시판 클릭하면 console 창에 "BoardListService"가 표시 됨
		
		
	}

}
