package ex15_interface;

public class Main {

	public static void main(String[] args) {
		
		// 메소드 호출 연습
		Phone p1 = new SmartPhone();
		
		if(p1 instanceof SmartPhone) {
		p1.call();						// p1은 전화기이므로 별도 캐스팅 없이 해당 기능을 불러올 수 있다.
		p1.sms();
		((Computer) p1).game(); 		//computer는 캐스팅을 시켜줘야 해당 기능을 불러올 수 있다.
		((Computer) p1).internet();
	
	
		Computer p2 = new SmartPhone();		
		((Phone) p2).call();
		((Phone) p2).sms();
		p2.game();
		p2.internet();

		
		SmartPhone p3 = new SmartPhone();
		p3.call();
		p3.sms();
		p3.game();
		p3.internet();
		

		}
	}

}
