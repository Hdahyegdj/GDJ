package ex02_roop;

public class Ex04_continue {

	public static void main(String[] args) {
		
		// continue문
		// 반복문의 시작 지점으로 이동한다.
		// 실행에서 제외할 코드가 있느 경우에 사용한다.
		// continue 없이 코드를 만드는 건 언제나 가능하다.
		
		// 설명
		//while()
		//	a;
		//	b;
		//	c;
		//	continue;      // abc만 실행하고 다시 while()문으로 돌아간다. (def는 실행되지 않음.)
		//	d;
		//	e;
		//	f;
		
		// 1 ~ !00 중에서 3의 배수를 제외하고 모두 더하기
		int total = 0;
		int n = 0;
				
		while(n < 100) {
			
			n++;		
			if(n % 3 == 0) {
				continue;           //다시 while(n < 100)으로 돌아감.
			}
			
			total += n;
		
		}
			System.out.println("합계 " + total);

	

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
