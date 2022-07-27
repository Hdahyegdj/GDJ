package ex01_one_dim;

public class Ex01_array {

	public static void main(String[] args) {
		
		// 배열(Array)
		// 1. 여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
		// 2. 구성 요소
		//	  1) 인덱스 : 각 변수의 위치 정보. 0으로 시작
		// 	  2) 배열명 : 모든 변수를 관리하는 하나의 이름
		// 3. 각 변수는 배열명에 대괄호(브라켓)"[]"와 인덱스를 붙여서 구분
		9
		// 배열 선언 및 생성 
		// 1. 배열 선언
		//	  int[] arr;    (인트 배열 타입의 이름이 arr이다.)
		//	  int arr[];    ->둘 다 동일하나 하기 패턴이 C언어에서 사용하던 방식으로 상기 방식을 추천
		// 2. 배열 생성
		//    arr = new int[3];
		// 3. 배열 선언 및 생성
		//    int[] arr = new int[3];
		
		// 배열 요소
		// 1. 배열로 관리되는 각각의 변수
		// 2. 모든 배열 요소의 호출
		//    arr[0]
		//	  arr[1]
		//	  arr[2]
		// 3. 배열 요소는 자동으로 초기화된다. (어떤 값을 가진다.)
		//    값이 없음을 의미하는 0, 0.0, false(boolean 일때), null(String 일때) 값을 가진다.
		
		// 배열의 장점
		// * 변수 3개가 있는 상황
		// 일반 변수					배열
		// int a, b, c;				 	int[] arr = new int[3];
		// system.out.println(a);		for(int i = 0; i < 3; 1++0 {
		// system.out.println(b);		system.out.println(arr[i]);
		// system.out.println(c);		}
		
		int[] arr = new int[3];
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);             //i가 없으면 j > k
		}
		
		arr[0] = 100;
		arr[1] = 50;
		arr[2] = 80;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// 학생 3명의 평균점을 내보자
		int total = 0;
		for(int i = 0; i <arr.length; i++) {
   			total += arr[i];
		}
	
		//double average = total / 3;
		//                 int     int (int끼리 나누면 double이 나올 수 없음.)
		//double average = (double)total / 3;      // 둘 중 하나 선택하여 사용하면 됨.
		double average = total / arr.length;              // 연산에 double에 하나는 포함시켜야 함.
		
		System.out.println("평균 : " + average + "점");
		
		
		
	}

}
