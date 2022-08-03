package ex14_interface;

public class Circle implements Shape {		//extends와 implements 의미는 동일 //class는 상속, interface는 구현 하는 것이다.
	
	private double radius;
	
	public Circle(double radius) {		// 생성자 생성
	super();
	this.radius = radius;
	}

	@Override								// ctrl + space를 통해 getAtra를 입력
	public double getArea() {
		return PI * Math.pow(radius, 2);
	}
	
	

}
