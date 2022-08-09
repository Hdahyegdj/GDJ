package practice3;

public class BreadAndChange {
	
	// 필드 
	private int bread;	 // 빵
	private int change;	 // 잔돈
	

	// 매개변수 없는 생성자
	public BreadAndChange() {		// 매게변수 없는 생성자 ctrl +space 1번쨰
	}

	// 매개변수 있는 생성자
	public BreadAndChange(int bread, int change) {		// source menu
	super();
	this.bread = bread;
	this.change = change;
	}

	
	// 메소드(get & set)
	public int getBread() {
		return bread;
	}
	public void setBread(int bread) {
		this.bread = bread;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}






	
	
	
	
	
	
	
	
	
	
}
