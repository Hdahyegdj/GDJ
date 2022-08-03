package ex06_constructor;

public class Student extends Person{
				//   --------------> 입력시 슈퍼클래스의 생성자를 호출하지 않아 오류 발생.(디폴트 형식이 아니기 때문에 자동 호출 불가)
	
	private String school; 
	
	// 하기 생성자는 Source-Generate Constructor Field에서 생성
	public Student(String name, String school) {	// 여기서 Person애서 이름을 전달해줌.(public Person(String name)), 매개변수 하나를 더 잡아
		super(name); 				//본래 Person이라 부르는게 맞으나 여기서는 super를 사용
		this.school = school;
		
	}

	
	public String getSchool() {			// getter&setter 추가
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
}
