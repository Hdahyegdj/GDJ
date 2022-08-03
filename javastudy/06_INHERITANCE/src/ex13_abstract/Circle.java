package ex13_abstract;

public class Circle extends Shape{
	
	private double redius;

	public Circle(String type, double redius) {			// 생성자 생성
		super(type);
		this.redius = redius;
	}
	
	// Shape 클래스는 추상 클래스이므로, 반드시 double getArea() 메소드를 오버라이드 해야함.
	@Override
	public double getArea() {  // double 타입을 반환하는 getArea
		return Math.PI * Math.pow(redius, 2);
	}
	

}
