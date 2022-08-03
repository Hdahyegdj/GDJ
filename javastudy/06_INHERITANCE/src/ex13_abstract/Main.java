package ex13_abstract;

public class Main {

	public static void main(String[] args) {
		
		// Shape 클래스 타입의 객체는 존재할 수 없는 객체이다.
		// abstract 처리해서 객체의 생성을 막을 수 있다.
		
		// Shape s1 = new Shape("도형");	// 추상 클래스 객체는 못 만들기에 주석 처리 함.
		// System.out.println(s1.getType());
		// System.out.println(s1.getArea());
		
		Shape s2 = new Circle("원", 1);		// Circle을 Shape(부모) 타입으로 바꿔도 가능.
		System.out.println(s2.getType());
		System.out.println(s2.getArea());

	}

}
