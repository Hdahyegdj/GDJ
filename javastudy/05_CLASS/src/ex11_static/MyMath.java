package ex11_static;

public class MyMath {
	
	// static
	// 1. 정적 요소
	// 2. 객체 생성 이전에 메모리에 미리 만들어 지는 공유 요소
	// 3. 클래스에서 1개만 만들어 짐
	// 4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드 라고 부름
	
	// 필드
	public static final double PI = 3.141592;                  
	
	// 메소드
	public static int abs(int n) {			  //메소드 중에 s가 붙어 있는거 가 메소드임.
		return (n >= 0) ? n : -n;             //전달된 n이 0보다 크면 아니면 -n으로 반환한다. 	
		}
	
	public static int pow(int a, int b) {
		// a의 b제곱 반환
		// for문 구현
		
		int result = 1;
		for(int cnt = 0; cnt < b; cnt++) {              // b만큼 반복해주고, result값을 더해준다.
			result *= a;
		}
		return result;
			
	}


}
