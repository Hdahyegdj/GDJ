package ex08_access_modifier;

public class User {
	
	// 필드는 private이다.
	private String id;
	private String password;
	private String email;
	private int point;    	//int는 정수
	private boolean isVip;
	
	// 메소드는 public이다.
	public String getId() {
		return id;
	}
	public void setId(String pId) {  		//"admin" pId 매개 변수로 전달됨.
		id = pId;
	}
	
	public String getPw() {
		return password;
	}
	public void setPw(String pPw) {
		password = pPw;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String pEmail) {
		email = pEmail;
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int pPoint) {
		point = pPoint;
		setVip(point >= 10000);
	}
	
	public boolean getVip() {
		return isVip;
	}
	public void setVip(boolean pVip) {            //public > private으로 바꾸면 호출을 차단
		isVip = pVip;
	}

}
