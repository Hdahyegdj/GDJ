package ex01_random;

public class Ex01 {   
	// ---------- class

	public static void main(String[] args) {
		       // --------- method  (클래스 안에 메소드가 들어있는 것)
		
		// 난수(Random number) 발생
		// Random 클래스, Math 클래스를 주로 활용한다.
		
		System.out.println(Math.random());     //math.를 입력하여 나오는 모든 초록 아이콘이 메소드 
		
		// 0.0 <= Math.random() < 1.0
		// 0%  <= Math.random() < 100%         //상하단 문장은 같은 개념으로 볼 수 있음.
		
		// 1. 확률 처리하기
		// 10% 확률로 "대박", 90% 확률로 "쪽박"
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}

		// 2. 난수 값 생성
		
		// Math.random()                    0.0 <= n < 1.0
		// Math.random() * 5                0.0 <= n < 5.0
		// (int)(Math.random() * 5)           0 <= n < 5
		// (int)(Math.random() * 5) + 1       1 <= n <6         -> 1부터 다섯개의 난수가 발생한다.(1이 4일 경우, 4부터 다섯개의 난수 발생)
		
		// 연습 
		// 주사위 2개를 던졌을 때 나올 수 있는 숫자
		for(int n = 0; n < 2; n++) {
			int dice = (int)(Math.random() * 6) + 1;
			System.out.println("주사위 " + dice);
		}
		
		// 연습
        // 6자리 숫자 인증번호 만들기         -> 이러한 문제는 'int'가 아닌 'String'으로 표현 해야함. (앞자리가 0일 경우 표현x, 전부 더해짐)
		// String code = "501924"
		
		String code = "";
		for(int n = 0; n < 6; n++) {
			code += (int)(Math.random() * 10);
		}
		System.out.println(code);
		
		// 연습 아스키 코드표 상 알페벳 A~Z의 랜덤값을 표현하기
		System.out.println((char)((int)(Math.random() * 26) + 65));                //(char) 명령어를 통해 숫자를 알파벳으로 변환. 65는 A로도 표현 가능함.
		
		// 예제
		// 1 + 1.5 
		// 1 + 'A'      ->둘다 계산 가능 A는 65로서 계산 됨.
        
		// 연습
		// 6자리 영문(대 + 소문자) 인증번호 만들기
		code = "";          //code 초기화
		for(int n = 0; n < 6; n++) {
			if(Math.random() < 0.5) {
				code += (char)((int)(Math.random() * 26) + 'A');
			} else {
				code += (char)((int)(Math.random() * 26) + 'a');
			}
		}
		System.out.println(code);
		
		
		
	
	}

}
