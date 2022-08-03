package ex12_object_class;

public class Main {

	public static void main(String[] args) {
		
		
		// Object 클래스는 모든 객체(변수)를 저장할 수 있다.
		Object p = new Person(); 	//p는 객체  //타입을 Person에서 Object로 변환
		
		
		// Object 클래스 타입의 객체는 항상 다운캐스팅해서 사용해야 한다.
		if(p instanceof Person) {// 다운캐스팅을 통해 .p에서 eat()를 호출하도록 한다. 
			((Person) p).eat();
		}		 //p. 후에 나오는 것 중 eat()를 제외한 모든 것이 전부 Object이다.

		
		// 새로운 Person(toString() 확인용)
		Person person = new Person();
		person.setName("james");
		
		System.out.println(person); // 패키지 클래스 명 추출(상기 james 추출)
		// System.out.println(p.toString()); // 상기 ()를 문자열로 변환하여 표시
		
		
		// 새로운 Person(equals() 확인용)
		// name이 같으면 동일한 객체로 인식하기
		Person p1 = new Person();
		Person p2 = new Person();
		p1.setName("kim");
		p2.setName("lee");
		System.out.println(p1.equals(p2)); 		// 동일한 name은 true
		
		
		
		// -----정리------
		// Object는 모든 걸 저장할 수 있다.
		// Object에 저장된 객체는 캐스팅해서 사용한다.
		// 객체 정보 확인을 위해서는 toString() 메소드를 만든다.
		// 객체 정보 비교를 위해서는 equals() 메소드를 만든다.
		// - source 메뉴에 가면 toString(), equals()를 만들어 준다.
		
		
			
		
	}

}
