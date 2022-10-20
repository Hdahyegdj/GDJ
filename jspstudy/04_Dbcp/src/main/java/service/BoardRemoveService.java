package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardRemoveService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터 
		Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));		// String을 감싸는 optional  // ofNullable : null값
		int board_no = Integer.parseInt(opt.orElse("0"));       // optional이 데이터가 없으면(null이거나) "0"을(만드는 이유는 "0"을 dao(게시글 번호가 0은 없기 때문에 삭제된게 없다는 걸 인식)로 전달해주기 위해) 준비해서 꺼내줌. 데이터가 있으면 그 데이터 그대로 꺼내줌
		
		// DB로 board_no 보내서 삭제
		int result = BoardDao.getInstance().deleteBoard(board_no);
		
		// 삭제 성공/실패 여부 콘솔에 출력
		System.out.println("삭제 여부 :  " + result);

		// 어디로 / 어떻게
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/list.do");	// Redirect 할 때는 매핑으로 이동   // 삭제 후 목록 보기로 가기
		af.setRedirect(true);	// DELETE 이후에는 Redirect  // delete 했을 때 redirect 만들기 
		
		return af;
		
	}

}
