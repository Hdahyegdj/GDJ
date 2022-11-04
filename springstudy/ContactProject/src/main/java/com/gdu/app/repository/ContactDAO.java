package com.gdu.app.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gdu.app.domain.ContactDTO;

//@Repository가 없습니다.
//com.gdu.contact.config.AppContext 클래스에서 ContactDAO를 @Bean으로 등록하였습니다.

public class ContactDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.ContactProject.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	
	private void close() {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<ContactDTO> selectAllContacts() {
		List<ContactDTO> contacts = new ArrayList<ContactDTO>();
		try {
			con = getConnection();
			sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT ORDER BY NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ContactDTO contact = new ContactDTO();
				contact.setNo(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setTel(rs.getString(3));
				contact.setAddr(rs.getString(4));
				contact.setEmail(rs.getString(5));
				contact.setNote(rs.getString(6));
				list.add(contact);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return contacts;
	}
	
	public ContactDTO selectContactByNo(int contact_no) {
		ContactDTO contact = null;
		try {
			con = getConnection();
			sql = "SELECT CONTACT_NO, NAME, TEL, ADDR, EMAIL, NOTE";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				contact = new ContactDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return contact;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
