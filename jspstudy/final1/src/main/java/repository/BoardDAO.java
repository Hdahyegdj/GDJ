package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.BoardDTO;

public class BoardDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private DataSource dataSource;
	
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO( ) {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
		} catch(NamingException e) {
			System.out.println("Resource name을 찾을 수 없습니다.");
		}
	}
	public static BoardDAO getInstance() {
		return dao;
	}
	
	
	// 접속 해제
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) con.close();  
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 목록
	public List<BoardDTO> selectAllBoards() {
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, IP, CREATE_DATE, MODIFY_DATE FROM BOARD ORDER BY NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setNo(rs.getLong("NO"));
				board.setWriter(rs.getString("WRITER"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setIp(rs.getString("IP"));
				board.setHit(rs.getLong("HIT"));
				board.setCreate_date(rs.getDate("CREATE_DATE"));
				board.setModify_date(rs.getDate("MODIFY_DATE"));
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return boards;
	}
	
	// 전체게시글수
	public long selectAllBoardsCount() {
		long count = 0L;
		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(*) AS 개 FROM BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getLong("개"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return count;
	}
	
	// 게시글삽입
	public int insertBoard(BoardDTO board) {
		int res = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO BOARD(NO, WRITER, TITLE, CONTENT, IP, HIT, CREATE_DATE, MODIFY_DATE) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, 0, SYSDATE, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContent());
			ps.setString(4, board.getIp());
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return res;
	}
	
	// 게시글조회
		public BoardDTO selectBoardByNo(Long no) {
			BoardDTO board = null;
			try {
				con = dataSource.getConnection();
				sql = "SELECT NO, WRITER, TITLE, CONTENT, IP, HIT, CREATE_DATE, MODIFY_DATE FROM BOARD WHERE NO = ?";
				ps = con.prepareStatement(sql);
				ps.setLong(1, no);
				rs = ps.executeQuery();
				if(rs.next()) {
					board = new BoardDTO();
					board.setNo(rs.getLong("NO"));
					board.setWriter(rs.getString("WRITER"));
					board.setTitle(rs.getString("TITLE"));
					board.setContent(rs.getString("CONTENT"));
					board.setIp(rs.getString("IP"));
					board.setHit(rs.getLong("HIT"));
					board.setCreate_date(rs.getDate("CREATE_DATE"));
					board.setModify_date(rs.getDate("MODIFY_DATE"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, rs);
			}
			return board;
		}
		
		// 조회수
		public int updateHit(long no) {
			int res = 0;
			try {
				con = dataSource.getConnection();
				sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE NO = ?";
				ps = con.prepareStatement(sql);
				ps.setLong(1, no);
				res = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
			return res;
		}
		
		// 게시글수정
		public int updateBoard(BoardDTO board) {
			int res = 0;
			try {
				con = dataSource.getConnection();
				sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, MODIFY_DATE = SYSDATE WHERE NO = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setLong(3, board.getNo());
				res = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
			return res;
		}
		
		// 게시글삭제
		public int deleteBoard(long no) {
			int res = 0;
			try {
				con = dataSource.getConnection();
				sql = "DELETE FROM BOARD WHERE NO = ?";
				ps = con.prepareStatement(sql);
				ps.setLong(1, no);
				res = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
			return res;
		}
	
	
	
	
	
	
	
	
	
	
}
