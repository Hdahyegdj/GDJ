package ex01_setter;

public class Main {

	public static void main(String[] args) {
		
		// Bean - 값을 가지고 있는 객체(VO라고도 부르며, DB로 보낼때는 DTO라고 부른다)
		
		User user = new User();
		user.setUserNo(1);
		user.setId("admin");
		user.setEmail("admin@naver.com");
		
		System.out.println(user);		// 이걸 실행하기 위해서는 toString의 메소드 값이 필요

	}

}
