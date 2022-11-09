package com.gdu.app09.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app09.domain.BoardDTO;


/*
	@Repository
	안녕. 난 DAO에 추가하는 @Component야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지.
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어 져.
*/


 @Repository	// 컴포넌트로 등록(servlet component가 자동으로 bean을 등록 시켜줌)
public class BoardDAO {
	 
	 // SqlSessionTemplate
	 // Mybatis에서 지원하는 매퍼 처리 클래스
	 
	 @Autowired
	 private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardDTO> selectAllBoards() {
		return sqlSessionTemplate.selectList("mybatis.mapper.board.selectAllBoards");		// sqlSessionTemplate은 필드값, mybatis.mapper.board은 mapper(board.xml)와 동일하게 입력 후, id값 붙여주기 
	}
	
	public BoardDTO selectBoardByNo(int boardNo) {		// boardNo는 mapper파일과 동일하게 입력	
		return sqlSessionTemplate.selectOne("mybatis.mapper.board.selectBoardByNo", boardNo);
	}
	
	public int insertBoard(BoardDTO board) {
		return sqlSessionTemplate.insert("mybatis.mapper.board.insertBoard", board);
	}
	
	public int updateBoard(BoardDTO board) {
		return sqlSessionTemplate.update("mybatis.mapper.board.updateBoard", board);
	}
	
	public int deleteBoard(int boardNo) {
		return sqlSessionTemplate.delete("mybatis.mapper.board.deleteBoard", boardNo);
	}
	

}
