package ex08_override;

public class Shape {

	private String type; 	//도형의 종류

	public Shape(String type) {		//생성자 자동 생성
		super();		//extends는 없으나 자동 생성 됨. 삭제해도 무방함.
		this.type = type;
	}
	
	public double getArea() {
		return 0; // 도형의 넓이는 현재 없다.
	}
	public void info() {
		System.out.println("도형의 종류 : " + type);
	}
	
}
