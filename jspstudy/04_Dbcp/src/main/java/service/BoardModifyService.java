package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardModifyService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		// <input type="text">, <textarea> 태그 요소는 입력 값이 없을 때 빈 문자열("")로 전달되므로
		// Optional은 사용 할 수 없다.	(Optional은 null을 대비, 빈문자열을 대비하는 건 없음)
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		// DB로 보낼 Board 생성
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setBoard_no(board_no);
		
		// DB로 Board 보내서 수정
		int result = BoardDao.getInstance().updateBoard(board);
		
		// 수정 결과는 콘솔에서 확인
		System.out.println("수정 결과 : " + result); 	// 0 : 실패, 1 : 성공
		
		// 어디로 / 어떻게
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/detail.do?board_no=" + board_no); 	  // Redirect 할 때는 매핑으로 이동(do로 이동)	// 게시글 상세보긴는 파라미터 no값을 사용해야함  
		af.setRedirect(true);										 						  // UPDATE 이후에는 Redirect(redirect 하겠다.)
		return af;
	}

}
