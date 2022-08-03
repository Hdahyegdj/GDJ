package ex08_override;

public class Main {

	public static void main(String[] args) {
		
		Circle circle = new Circle("도넛", 7.5);  	//반지름이 7.5인 도넛
		circle.info(); 		//circle의 System.out.println("넓이 : " + getArea());의 getArea를 호출
		
		
		Rectangle rectangle = new Rectangle("사각형", 3, 4);
		rectangle.info();
		
		Square square = new Square("정사각형", 5);
		square.info();
		

	}

}
