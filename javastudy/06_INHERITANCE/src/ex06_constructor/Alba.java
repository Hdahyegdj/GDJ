package ex06_constructor;

public class Alba extends Student{
	
	private String company; 	//필드값 생성
	
	public Alba(String name, String school, String company) { 		//생성자는 Souce메뉴에서 입력
		super(name, school);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	

}
