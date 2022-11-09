package com.gdu.app10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app10.domain.BoardDTO;
import com.gdu.app10.mapper.BoardMapper;


/*
	@Service
	안녕. 난 Service에 추가하는 @Component야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지.
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어 져.
*/

@Service	// 컴포넌트로 등록
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> findAllBoards() {
		return mapper.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		return mapper.selectBoardByNo(board_no);
	}

	@Override
	public int saveBoard(BoardDTO board) {
		return mapper.insertBoard(board);		
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		return mapper.updateBoard(board);
	}

	@Override
	public int removeBoard(int board_no) {
		return mapper.deleteBoard(board_no);
	}
	
	

}
