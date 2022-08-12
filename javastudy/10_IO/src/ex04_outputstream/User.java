package ex04_outputstream;

import java.io.Serializable;

// 스트림을 이용해서 객체로 전송하려면 직렬화를 해야 한다.
// 직렬화가 필요한 객체는 Serializable 인터페이스를 구현해야 한다.
// Serializable 인터페이스를 구현한 클래스는 serialVerionUID 필드가 필요하다.


public class User implements Serializable { 	/**		// implements Serializable :Serializable 인터페이스를 구현
	 * 
	 */
	private static final long serialVersionUID = -1830845902387248224L;  	// serialVerionUID 필드(왼쪽 에러를 통해 "generate 생성"

	
	private int userNo;
	private String name;
	private int age;
	
	
	public User(int userNo, String name, int age) {  	//생성자
		super();
		this.userNo = userNo;
		this.name = name;
		this.age = age;
	}
	

	@Override		// toString
	public String toString() {
		return "User [userNo=" + userNo + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
