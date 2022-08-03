package quiz03_bus;

public class Person {
	
	private String name; 	 // 부모 클래스는 모든 클래스가 공통으로 갖는 항목을 만들어줌.

	public Person(String name) {		//생성자 자동 기입
		super();
		this.name = name;
	}

	public String getName() {			//getter&setter
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
