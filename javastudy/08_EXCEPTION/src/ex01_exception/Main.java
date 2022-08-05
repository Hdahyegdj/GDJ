package ex01_exception;

import java.util.Scanner;

public class Main {
	
	public static void m1() {
	     //------> m1를 부르기 때문에 반드시 필요함.
		// NullPointerException : null 값이 어떤 메소드를 호출할 때 발생
		String[] hobbies = new String[5];
		
		hobbies[1] = " 수영";		// exception 발생 원인이 m1임.
		hobbies[2] = " 골프";
		hobbies[3] = " 영화";
		hobbies[4] = " 집콕";
		
		for(int i = 0; i <hobbies.length; i++) { 	// 반복문
			if(hobbies[i].equals("수영")) {
				System.out.println("취미가 나와 같군요");
			}
		}
	}
	
	public static void m2() {
		// NullPointerException 회피
		String[] hobbies = new String[5];
		
		hobbies[1] = " 수영";		// exception 발생 원인이 m1임.
		hobbies[2] = " 골프";
		hobbies[3] = " 영화";
		hobbies[4] = " 집콕";
		
		for(int i = 0; i <hobbies.length; i++) { 	// 반복문
			if(hobbies[i] != null && hobbies[i].equals("수영")) {	// m1에서는 hobbies 값이 null이어, 에러가 발생했으므로 null값이 아니다라고 입력(정상 실행). null chk는 먼저 해야함.
				System.out.println("취미가 나와 같군요");
			}
		}
	}
	
	public static void m3() {		
		// NumberForematException : String을 Number타입으로 변경할 때 발생
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine();
		System.out.println("나이 입력(필수) >>> ");
		String strAge = sc.nextLine();		// 입력 없이 Enter만 누르면 strAge는 빈 문자열을 가짐.
		int age = Integer.parseInt(strAge);
		
		System.out.println("이름:" + name + ",나이:" + age + "살");	
		
	}	
	
	public static void m4() {		
		// NumberForematException 회피
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine();
		System.out.println("나이 입력(필수) >>> ");
		String strAge = sc.nextLine();		// 입력 없이 Enter만 누르면 strAge는 빈 문자열을 가짐.
		
		int age;
		if(strAge.isEmpty()) {
			age = 0;
		} else {
			age = Integer.parseInt(strAge);
		}
		System.out.println("이름:" + name + ",나이:" + age + "살");	
		
	}
	
	
	public static void main(String[] args) {
		m4();
		
	}

	
	
}
