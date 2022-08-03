package ex08_override;

public class Circle extends Shape {
	
	private double radius;

	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}

	@Override 		//source 메뉴 및 ctrl 사용하여 입력 가능
	public double getArea() {
		// TODO Auto-generated method stub
				//return super.getArea(); 사용하지 않으므로 삭제
		return Math.PI + Math.pow(radius, 2);		//Math. 으로 PI값을 선택, redius의 2제곱
	}
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();  // Shape의 public void info()를 부름.
		System.out.println("반지름 : " + radius);
		System.out.println("넓이 : " + getArea());  //getArea는 상기의 메소르를 호출(같은 메소드끼리도 호출 가능)
		
	}
	
	
	
	
	
	

}
