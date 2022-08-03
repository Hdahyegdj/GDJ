package ex12_object_class;

public class Person {

	private String name;
	
	
	public String getName() {			// get&set가 있어야 이름에 저장도 호출도 가능
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void eat() {
		System.out.println("먹는다.");
	}
	
	
	@Override
	public String toString() {			//Genarate to String에서 해당 내용 선택하여 생성 가능함.
		return "이름 : " + name;		//System.out.println(person);에서 사용됨.  // 주로 디버깅(오류 찾는) 용도로 많이 사용함.
	}
	

	@Override
	public boolean equals(Object anObject) 	{		// p1.equals(p2)에서 사용됨.
		Person p = (Person) anObject;
		return name.equals(p.name);			//전자 name은 p1(본인), 후자 name은 p2를 가르키므로 둘을 비교함.	// 여기서 equals는 String의 equal를 사용함.
	}
	
}
