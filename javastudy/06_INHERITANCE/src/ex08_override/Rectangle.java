package ex08_override;

public class Rectangle extends Shape {
	
	private double width;
	private double height;
	
	public Rectangle(String type, double width, double height) {   // 생성자 자동 생성 (type 추가 입력 필요)
		super(type);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return super.getArea();
	}
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();
	}
	
	
	
	
		
	

}
