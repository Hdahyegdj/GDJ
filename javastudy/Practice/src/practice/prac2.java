package practice;

import java.util.Scanner;

public class prac2 {

	public static void main(String[] args) {
		System.out.println("=====문제1=====");
		//q1();
		System.out.println("=====문제2=====");
		//q2();
		System.out.println("=====문제3=====");
		q3();
		System.out.println("=====문제4=====");
		//q4();
		System.out.println("=====문제5=====");
		//q5();
		System.out.println("=====문제6=====");
		//q6();
		System.out.println("=====문제7=====");
		//q7();
		System.out.println("=====문제8=====");
		//q8();
		System.out.println("=====문제9=====");
		//q9();
	}
		
		
		// 문제1. 점수와 학년을 입력받아 60점 이상이면 합격, 60점 미만이면 불합격을 출력하시오.
		// 		  4학년인 경우 70점 이상이어야 합격이다.
		
		public static void q1() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("점수를 입력하세요(0~100 >>> ");
			int score = sc.nextInt();
			System.out.println("학년을 입력하세요(0~100 >>> ");
			int year = sc.nextInt();
			
			if (score >= 60) {
				if (year != 40)
					System.out.println("합격");
				else if (score >= 70)
					System.out.println("합격");
				else 
					System.out.println("불합격");
			} else {
				System.out.println("불합격");
			}
			
	}
		
		
		// 문제 2. 커피 메뉴를 입력받아 가격을 알려주는 프로그램을 구현하시오. 
		// switch문을 이용하여 구현하시오.
		// (에스프레소, 카푸치노, 카페라떼는 3500원, 아메리카노는 2000원이다.)
		
		public static void q2() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("무슨 커피 드릴까요? >>>");
			String order = sc.next();
			int price = 0;
			
			switch (order) {
			case "에스프레소":
			case "카푸치노":
			case "카페라떼":
				price = 3500;
				break;
			case "아메리카노":
				price = 2000;
				break;
			default:
				System.out.println(order + "는 메뉴에 없습니다.");			
			}
			
			if (price != 0)
				System.out.println(order + "는 " + price + "원입니다.");
	
		}
		
		
		// 문제 3. 돈을 입력받아 오만원권, 만원권, 오천원권, 천원권, 오백원 동전, 백원 동전, 오십원 동전,
		// 십원 동전, 오원 동전, 일원 동전이 각각 몇 개로 변환되는지 출력하시오. 
		// 이 때 반드시 다음과 같은 배열을 사용하여 반복문으로 처리하시오.
		// int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1}
		
		public static void q3() {

			int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
			int[] count = new int[unit.length];
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("금액 입력 >>> ");
			int money = sc.nextInt();
			
			for(int i = 0; i < unit.length; i++) {
				count[i] = money / unit[i];
				money = money % unit[i];
				System.out.println(unit[i] + "원" + count[i] + "개");
			}
			sc.close();
			
			}
			
		
		// 문제 4. 정수를 몇 개 저장할지(최대 100개) 입력받아서 해당 길이를 가진 배열을 생성하고,
		// 이곳에 1에서 100사이 범위의 정수를 랜덤하게 삽입하시오. 같은 값은 생성하지 못하도록
		// 설정하고 생성된 배열을 출럭하시오.
		
		public static void q4() {
			int number = (int)(Math.random() * 100) + 1;
				System.out.println(number);
			
		}
		
		
		// 문제 5. 3명의 학생의 점수를 입력 받아서 평균 점수와 1등의 이름과 꼴등의 이름을 출력하시오.
		
		//피카츄의 점수 입력 >>> 
		//뽀로로의 점수 입력 >>> 
		//브레드의 점수 입력 >>> 
		//평균 :
		//1등 :
		//3등 : 


		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
