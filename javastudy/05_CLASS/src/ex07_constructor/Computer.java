package ex07_constructor;

public class Computer {
	
	// 생성자(Constructor)
	// 1.객체 생성할 때 사용되는 특별한 메소드
	// 2. 특징
	//	  1) 메소드 이름이 클래스 이름과 같다.	
	// 	  2) 반환타입이 존재하지 않는다.
	// 3. 생성자는 필드 초기화 용도로 사용
	
	// 디폴트 생성자(Default Constructor)
	// 1. 개발자가 생성자를 만들지 않으면 자바가 자동으로 생성하는 생성자
	// 2. 아무 일도 안하는 형태
	//    Computer() {}
	
	
	// 필드
	String model;
	int price;
				//new Computer();   -> 필드값이 초기화되는 값
				//new Computer("gram", 150);   -> 필드값을 (인수 두개의)그램 150으로 설정하는 값
				//생성자인 Computer( ) 괄호 안에 상기 값이 들어가는 걸 매개 변수라 한다.
				//(인수가 있으면 매개변수를 있는 걸 호출하는 식으로 서로 짝이 맞는 걸 호출해야함.)
	
	// 생성자
	//Computer(){								// 이름이 같고 반환 타입이 다르기 때문에 오류가 사라짐.
		
	//}
	
	Computer(String pModel, int pPrice) {     //현재 pModel에는 Main에서 입력한 그램이 반영 됨.
		model = pModel;
		price = pPrice;
	}
	
	
	// 메소드
	void printComputerStatus() {
		System.out.println("모델 : " + model);
		System.out.println("가격 : " + price);
	}
	
	
	Computer(){     //메소드 생성자로 인식
		System.out.println("컴퓨터 생성");
	}
	
	
}
