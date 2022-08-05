package ex04_throw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// throw
		// 1. 예외 객체를 만들어서 직접 throw(던질수) 할 수 있다.
		// 2. 자바를 예외로 인식하지 않지만 실제로는 예외인 경우에 주로 사용된다.
		
		Scanner sc = new Scanner(System.in); // 중괄호 안(scope 범위)에서만 실행{모든 객체와 변수는 동일)됨으로 밖으로 꺼내어 사용 범위를 조정.
		try {
			System.out.println("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			if(age < 0 || age > 100) {
				throw new RuntimeException("나이는 0이상 100 이하만 가능합니다."); 		// RuntimeException(String msg)  // 이 문장은 catch문에 Exception e가 받음.
			}
			System.out.println(age >= 20 ? "성인" : "미성년자");
			//sc.close();			// 예외가 발생해서 하기 코드가 실행되지 않을 수도 있으나. scanner는 자동으로 닫히는 경우가 있어서 실행될 수도 있음.
		} catch (Exception e) {		// 여기서 Exception e는 new RuntimeException("나이는 0이상 100 이하만 가능합니다.")임.
			System.out.println(e.getMessage());
		} finally {
			sc.close();		// 실제로 finally는 자원을 반납할 때 주로 사용됨.( finally에는 대부분 close가 들어감.)
			System.out.println("finally 블록 실행");
		}

	}

}
