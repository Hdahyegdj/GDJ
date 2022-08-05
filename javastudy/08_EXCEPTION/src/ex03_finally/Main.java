package ex03_finally;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// finally 블록
		// 1. try-catch문 마지막에 추가하는 블록
		// 2. 언제나 마지막에 실행되는 블록
		
		Scanner sc = new Scanner(System.in); // 중괄호 안(scope 범위)에서만 실행{모든 객체와 변수는 동일)됨으로 밖으로 꺼내어 사용 범위를 조정.
		try {
			System.out.println("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			System.out.println(age >= 20 ? "성인" : "미성년자");
			//sc.close();			// 예외가 발생해서 하기 코드가 실행되지 않을 수도 있으나. scanner는 자동으로 닫히는 경우가 있어서 실행될 수도 있음.
		} catch (Exception e) {
			System.out.println("예외 발생");
		} finally {
			sc.close();		// 실제로 finally는 자원을 반납할 때 주로 사용됨.( finallt에는 대부분 close가 들어감.)
			System.out.println("finally 블록 실행");
		}

	}

}
