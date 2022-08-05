package ex04_builder;

public class Main {

	public static void main(String[] args) {
		
		User user = User.builder()
					.userNo(1)
					.id("admin")
					.email("admin@naver.com")
					.build();
						
						
						// 마지막에 build 메소드를 기입하여 종료
	
				
				System.out.println(user);
	}

}
