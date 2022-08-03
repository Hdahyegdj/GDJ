package ex10_downcasting;

public class Main {

	public static void main(String[] args) {
		
		// 클래스타입 : Person
		// 객체(인스턴스) = p
		// 인스턴스화 : 메모리에 객체가 만들어 지는 순간
		
		Person p = new Alba();			// upcasting
		
		// instanceof 연산자
		// 특정 인스턴스가 어떤 클래스 타입인지 점섬하는 연산자
		// 해당 클래스 타입이면 true를 반환, 아니면 false 반환
		
		System.out.println(p instanceof Person);
		System.out.println(p instanceof Student);	// 상단 Person p = new Alba();의 new Alba를 Student로 변경하면 하기 Alba는 false.(하단 if문도 실행되지 않음)
		System.out.println(p instanceof Alba);  	// 상단 Person의 p는 사람이기도 하나 실제로는 Alba이기 때문에 3개 전부 true가 나와야함.
		
		// p가 Student 타입의 인스턴스이면 study() 메소드를 호출할 수 있다.
		if(p instanceof Student) {
			((Student) p).study();   //p. 입력후 study 선택(if를 주었기 때문에 study가 보임.) -> downcasting 자동 완성됨.
		}
		
		if(p instanceof Alba) {
			((Alba) p).Work();
		}

	}

}
