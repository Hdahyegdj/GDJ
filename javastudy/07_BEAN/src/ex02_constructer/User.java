package ex02_constructer;

public class User {
	
	private int userNo;
	private String id;
	private String email;
	
	
	public User(int userNo, String id, String email) {		// 생성자
		super();
		this.userNo = userNo;
		this.id = id;
		this.email = email;
	}


	@Override		// toString
	public String toString() {
		return "User [userNo=" + userNo + ", id=" + id + ", email=" + email + "]";
	}

	
	

	
	
}
