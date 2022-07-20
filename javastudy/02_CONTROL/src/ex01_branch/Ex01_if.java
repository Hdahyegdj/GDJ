package ex01_branch;

public class Ex01_if {

	public static void main(String[] args) {
		
		// if문
		// 조건을 만족하는 경우에만 실행
		// if(조건){
		// 		실행문
		// }
		
		int score = 100;
		
		if(score >= 60) {   //실행문이 하나 일때 중괄호는 생략 가능(합/불만 있을때 가능하나, 축하메세지 작성 시 불가)
			System.out.println("합격");
			System.out.println("축하합니다");
		}

		if(score <= 60) {
			System.out.println("불합격");
		}

		
		
	}

}
