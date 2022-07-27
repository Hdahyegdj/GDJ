package ex01_one_dim;

public class Ex04_advanced_for {

	public static void main(String[] args) {
		
		String[] friends = {"라이언", "프로도", "어피치"};
				
		for(int i = 0; i < friends.length; i++) {
			System.out.println(friends[i]);
		}

		// 일반 for문 연습. 1번째 친구 : 라이언, 2번째 친구 : 프로도, 3번째 친구 : 어피치로 만들어보자.
		for(int i = 0; i < friends.length; i++) {
			System.out.println((i + 1) + "번째 친구 : " + friends[i]);
		}
		
		
		// 향상 for문                   // 모든 영역에서 향상문이 일반문을 대체 할 수 없다. 상황에 따라 편하게 이용할 수 있는 경우가 있을뿐.
		for(String friend : friends) {  // friends 배열의 모든 요소를 하나씩 String friend로 옮긴다.
			System.out.println(friend);
		}
		
		
		
	}

}
