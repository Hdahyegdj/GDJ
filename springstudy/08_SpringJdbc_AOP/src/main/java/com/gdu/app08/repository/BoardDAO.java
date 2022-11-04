package com.gdu.app08.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.gdu.app08.domain.BoardDTO;


/*
	@Repository
	안녕. 난 DAO에 추가하는 @Component야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지.
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어 져.
*/


 @Repository	// 컴포넌트로 등록(sevlet component가 자동으로 bean을 등록 시켜줌)
public class BoardDAO {
	 
	 // JdbcTemplate
	 // Connection, PreparedStatement, ReusltSet을 내부에서 사용하는 스프링 클래스
	 // DriverManagerDataSource에 의해서 Connection Pool 방식으로 동작
	 
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public List<BoardDTO> selectAllBoards() {
		String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD ORDER BY BOARD_NO DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class));	// DB BeanPropertyRowMapper와 bean의 프로퍼티 이름(BoardDTO)이름이 같으면 알아서 mapping해줌
		// List<BoardDTO> boards = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class));
		// return boards;    // 상기 코드와 동일
	}
	
	public BoardDTO selectBoardByNo(final int board_no) {	// 매개변수 final 처리(이전 버전에서 사용하지 않으면 err) : 사용하지 않아도 됨.(더이상 매개변수 변경 x)
		String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD WHERE BOARD_NO = ?";		// 조건이 필요하므로 WHERE 절 사용
		BoardDTO board = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDTO.class), board_no);   // 마지막 board_no는 쿼리문의?에 전달할 내용
		return board;
	}
	
	public int insertBoard(final BoardDTO board) {
		String sql = "INSERT INTO BOARD(BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE) "
				   + "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {	// 본래 interface는 new로 만들 수 없으나 여기서 직접 만들어서 넣을 수 있다.
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {	// ps.set 값만 입력하면 됨
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setString(3, board.getWriter());		// ?, ?, ?에 들어가는 내용을 sql문과 동일하게 입력	
			}
		}); 
		return result;
	}
	
	public int updateBoard(final BoardDTO board) {
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, MODIFY_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE BOARD_NO = ?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setInt(3, board.getBoard_no());
			}
		});				
		return result;
	}
	
	public int deleteBoard(final int board_no) {
		String sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, board_no);
			}
		});
		return result;
	}
	

}
