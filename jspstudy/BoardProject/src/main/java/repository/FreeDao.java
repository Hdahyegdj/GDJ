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

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.Free;

public class FreeDao {
	
		private Connection con;
		private PreparedStatement ps;
		private ResultSet rs;
		private String sql;
		
		private SqlSessionFactory factory;
		

		private DataSource dataSource;
		

		private static FreeDao dao = new FreeDao();
		private FreeDao() {
			try {
				Context ctx = new InitialContext();
				
				Context envCtx = (Context)ctx.lookup("java:comp/env");  
				dataSource = (DataSource)envCtx.lookup("jdbc/oracle11g");
			} catch(NamingException e) {
				e.printStackTrace();
			}
		}
		public static FreeDao getInstance() {
			return dao;
		}
		

		public void close(Connection con, PreparedStatement ps, ResultSet rs) {
			try {
				if(rs != null) { rs.close(); }
				if(ps != null) { ps.close(); }
				if(con != null) { con.close(); }	// Connection Pool의 close()는 Connection 종료가 아닌 Connection 반환으로 동작
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		public List<Free> selectAllFrees() {
			List<Free> frees = new ArrayList<Free>();
			try {
				con = dataSource.getConnection();	
				sql = "SELECT FREENO, WRITER, TITLE, CONTENT, IP, HIT";		
				ps = con.prepareStatement(sql);		
				rs = ps.executeQuery();	  
				while(rs.next()) {	 

					Free free = new Free();
					free.setFreeNo( rs.getLong(1) );		
					free.setWriter( rs.getString(2) );		
					free.setTitle( rs.getString(3) );		
					free.setContent( rs.getString(4) );	
					free.setIp( rs.getString(5) );		
					free.setHit( rs.getLong(6) );		

					frees.add(free);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, rs);
			}
			return frees;
		}
		

		public Free selectFreeByNo(int free_no) {
			Free free = null;
			try {
				con = dataSource.getConnection();
				sql = "SELECT FREENO, WRITER, TITLE, CONTENT, IP, HIT FROM FREE WHERE FREENO = ?";   
				ps = con.prepareStatement(sql);
				ps.setInt(1, free_no);	  
				rs = ps.executeQuery();   
				if(rs.next()) { 		 
					 free = new Free();
					 free.setFreeNo( rs.getLong(1) );		
					 free.setWriter( rs.getString(2) );		
					 free.setTitle( rs.getString(3) );		
					 free.setContent( rs.getString(4) );	
					 free.setIp( rs.getString(5) );		
					 free.setHit( rs.getLong(6) );		
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, rs);
			}
			return free;
		}
		

		public int insertFree (Free free) {
			int result = 0;
			try {
				con = dataSource.getConnection();
				sql = "INSERT INTO FREE VALUES(FREE_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";			
				ps = con.prepareStatement(sql);
				ps.setString(1, free.getWriter());
				ps.setString(2, free.getTitle());
				ps.setString(3, free.getContent());
				result = ps.executeUpdate();	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
			return result;
		}
		

		public int updateFree(Free free) {
			int result = 0;
			try {
				con = dataSource.getConnection();
				sql = "UPDATE BOARD SET WRITER = ?, TITLE = ?, CONTENT = ? WHERE BOARD_NO = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, free.getWriter());
				ps.setString(2, free.getTitle());		
				ps.setString(3, free.getContent());
				ps.setLong(4, free.getFreeNo());
				result = ps.executeUpdate(); 		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
			return result;
		}
		

		public int deleteFree(int free_no) {
			int result = 0;
			try {
				con = dataSource.getConnection();
				sql = "DELETE FROM FREE WHERE FREENO = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, free_no);		
				result = ps.executeUpdate();	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
			return result;
		}
		

		public List<Free> selectFreeJob() {
			SqlSession ss = factory.openSession();
			List<Free> job = ss.selectList("mybatis.mapper.student.selectFreeJob");
			ss.close();
			return job;
		}


	}
