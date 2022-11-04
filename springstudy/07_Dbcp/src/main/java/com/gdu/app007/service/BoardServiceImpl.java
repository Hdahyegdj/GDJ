package com.gdu.app007.service;

import java.util.List;

import com.gdu.app007.domain.BoardDTO;
import com.gdu.app007.repository.BoardDAO;

import lombok.AllArgsConstructor;


/*
	@Service
	안녕. 난 Service에 추가하는 @Component야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지.
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어 져.
*/


// @Service 를 사용하지 않고 config패키지에서 bean을 통해 작성    // Service가 사용하는 @Component

public class BoardServiceImpl implements BoardService {
	
	
	// Service는 DAO를 사용합니다.  
	// @Autowired	 // 컨테이너에 생성된 bean 중에서 BoardDAO 타입의 bean을 가져오시오.  // BoardDAO는 컨테이너에 있어야함.(@Repository를 사용하지 않으면 BoardDAO는 만들어지지 않아서 에러 발생)
	
	// AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BoardAppContext.class);		// @Autowired 대신 사용 @Override 상 연결도 만들어줘야함.
	// private BoardDAO dao = ctx.getBean("dao", BoardDAO.class);
	
	private BoardDAO dao;
	
	// 생성자의 매개변수 BoardDao dao로 new BoardDAO()가 주입되고 있다.
	// BoardAppContext.java를 참고
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		return dao.selectBoardByNo(board_no);
	}

	@Override
	public int saveBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int board_no) {
		return dao.deleteBoard(board_no);
	}

}
