package ex14_interface;

public class Main {

	public static void main(String[] args) {
		
		Shape s = new Circle(1); // 반지름이 1인 원형이 생성
		System.out.println(s.getArea());
	}

}
