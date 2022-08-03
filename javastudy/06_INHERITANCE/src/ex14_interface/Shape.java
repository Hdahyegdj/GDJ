package ex14_interface;

public interface Shape {
	
	// final 상수
	public final static double PI = 3.1415952;   	//<- 만 사용 가능 private String type 은 사용 불가 
	
	// 추상 메소드
	public abstract double getArea(); 	//public 과 abstract는 생략 가능하나 보편적으로 abstract만 생략
	
	// default 메소드(본문이 있는 메소드)
	public default void message() {
		System.out.println("나는 도형이다.");
	}
	
	
	
}
