package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
				
		user.setId("admin");           		 //admin이 setId메소드를 통해 User에 전달되어 넘어감.
		System.out.println(user.getId());
		
		user.setPw("1234");
		System.out.println(user.getPw());
		
		user.setEmail("dahye@email.com");
		System.out.println(user.getEmail());
		
		user.setPoint(1000);                  // int는 정수 이기 떄문에 ""불요
		System.out.println(user.getPoint());
		
		user.setVip(false);
		System.out.println(user.getVip());
		
		
	}

}
