package repository;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.ContactDTO;

public class ContactDAO {
	
	/************************* Singleton *************************/

	// DAO(데이터 베이스 접근 객체)는 하나의 객체만 생성할 수 있도록
	// Singleton Pattern으로 생성  // 7장 3 패키지 참조
	
	// Singleton 패턴 - 1
	// ContactDAO 객체를 하나 만들어 둔다.
	private static ContactDAO contactDAO = new ContactDAO();
	
	// Singleton 패턴 - 2
	// 외부에서는 ContactDAO 객체를 못 만들도록 제한한다.
	// private 생성자
	private ContactDAO() {
		
	}
	
	// Singleton 패턴 - 3
	// 만들어 둔 ContactDAO 객체를 외부에 반환한다.
	public static ContactDAO getInstance() {
		return contactDAO; 
	}
	
	
	/************************* Field *************************/
	
	// 데이터베이스에 접근할 때 사용하는 공통 요소
	private Connection con;			// DB접속
	private PreparedStatement ps;	// 쿼리문 실행
	private ResultSet rs;			// SELECT 결과
	private String sql; 			// 쿼리문(하단 String값을 생략 가능)
	private int result;				// INSERT, UPDATE, DELETE 결과 

	
	
	/************************* Method *************************/
	
	// 모든 데이터베이스 작업(CRUD : CREATE/READ/UPDATE/DELETE)		// CREATE가 INSERT, READ가 SELECT를 의미함.
	// 1. Connection 객체 생성
	// 2. close
	
	// 공통 메소드 - 1
	public Connection getConnection() throws Exception {
		
		// oracleDriver 클래스 로드
		Class.forName("oracle.jdbc.OracleDriver");
		
		// Connection 객체 반환
		// db.properties 파일의 접속 정보 읽기
		Properties p = new Properties();
		p.load(new FileReader("db.properties")); 	// 경로가 없는 파일은 프로젝트 디렉터리에 있다는 의미(14_JDBC\\db.properties)에 있다는 의미
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		return DriverManager.getConnection(url, user, password);

	}
	
	// 공통 메소드 - 2
	public void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*  접속 확인
	public static void main(String[] args) {
		
		try {

			ContactDAO dao = ContactDAO.getInstance();
			Connection con = dao.getConnection();
		
			System.out.println("접속 성공");
			
		} catch(Exception e) {
			System.out.println("오류");
		}
	}
	*/
	
	
	// 연락처 추가 메소드
	// 1. 매개변수 : ContactDTO
	// 2. 반환값   : 0 또는 1 (int 값)
	public int insertContact(ContactDTO contact) {
		
		try {
			con = getConnection();
			sql = "INSERT INTO CONTACT VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";  // 변수처리 : ?  // ?, ?, ?는 상단의 contact에 들어있어야함.
			ps  = con.prepareStatement(sql);
			ps.setString(1, contact.getName());   // 여기서 1은 첫번째 물음표를 의미함  // contact.getName()에서 첫번째 이름을 가져옴.
			ps.setString(2, contact.getTel()); 
			ps.setString(3, contact.getEmail());
			result = ps.executeUpdate(); 	// 실행 명령(1이 출력되면 insert 성공, 0이 출력되면 insert 실패)
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(); 	// 공통 메소드-2에서 닫아주는 메소드를 생성해 놨기 때문에 불러주기만 하면됨.
		}
		
		return result;
	}
	
	
	// 연락처 수정 메소드
	// 1. 매개변수 : ContactDTO
	// 2. 반환값   : 0 또는 1
	public int updateContact(ContactDTO contact) {
		
		try {
			con = getConnection();
			sql = "UPDATE CONTACT SET NAME = ?, TEL = ?, EMAIL = ? WHERE CONTACT_NO = ?";
			ps  = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setInt(4, contact.getContact_no());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
		
	}
	
	
	// 연락처 삭제 메소드
	// 1. 매개변수 : ContactDTO
	// 2. 반환값   : 0 또는 1
	public int deleteContact(int contact_no) {
		
		try {
			con = getConnection();
			sql = "DELETE FROM CONTACT WHERE CONTACT_NO = ?";
			ps  = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
		
	}
	
	
	// 연락처 조회 메소드
	// 1. 매개변수 : contact_no
	// 2. 반환값   : ContactDTO 또는 null
	public ContactDTO selectContactByNo(int contact_no) {
		
		ContactDTO contact = null;
		
		try {
			con = getConnection();
			sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, REG_DATE FROM CONTACT WHERE CONTACT_NO = ?";
			ps  = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			rs  = ps.executeQuery();
			if(rs.next()) {		// 반드시 next를 사용해야함.
				contact = new ContactDTO(); 	// 검색 결과가 있으면 만들기 (최초 값 null)
				contact.setContact_no(rs.getInt(1));    // 1열은 int값이므로
				contact.setName(rs.getString(2));
				contact.setTel(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setReg_date(rs.getDate(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return contact;
		
	}
	
	
	// 연락처 목록 메소드
	// 1. 매개변수 : 없음
	// 2. 반환값 : List<ContactDTO>
	public List<ContactDTO> selectAllContacts() {		// 하기 Contact값이 List이므로 반환값을 동일하게 만들어줌.(실제로 만든건 Array List 임)
		
		List<ContactDTO> contacts = new ArrayList<ContactDTO>();
		
		try {
			con = getConnection();
			sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, REG_DATE FROM CONTACT";
			ps  = con.prepareStatement(sql);
			rs  = ps.executeQuery();
			while(rs.next()) {
				ContactDTO contact = ContactDTO.builder()
						.contact_no(rs.getInt(1))
						.name(rs.getString(2))
						.tel(rs.getString(3))
						.email(rs.getString(4))
						.reg_date(rs.getDate(5))
						.build();					// 상기와 같은 내용(build 패턴으로 표현(롬북 사용))
				contacts.add(contact);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return contacts;
	}

	
}
