package ex06_constructor;

public class Person {
	
	private String name;		//필드값이 생김.
	
	public Person(String name) {
		this.name = name;     		//디폴트 값이 있는 생성자
	}

	public String getName() {		//Getter Setter 값 자동으로 추가하기
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
