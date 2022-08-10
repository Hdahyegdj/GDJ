package ex02_try_catch;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void m1() {
		try {
			String[] hobbies = new String[3];
			hobbies[1] = "swimming";
			hobbies[2] = "running";
			for(String hobby : hobbies) {		// 향상 for문
				System.out.println(hobby.substring(0, 2)); //substring : 첫번쨰와 두번째 글자만 나타내겠다.
			}
		}  catch(Exception e) {	 // 여기까지가 try 블락  // RuntimeException, NullpointerException 가능 	// e : 예외객체를 나타냄	// ctrl+space로 확인하여 입력
			System.out.println("NullpointerException 발생");
		}	// catch 블락 		
		
	}

	
	public static void m2() {
		try {
			String input = "20, 21, 22, 23, 24, 25";	// ,, 오류 처리하기
			String[] inputs = input.split(",");			// ", " 분리
			int[] ages = new int[inputs.length];
			for(int i = 0; i < inputs.length; i++) {
				ages[i] = Integer.parseInt(inputs[i]);
				System.out.println("변환 값 : " + ages[i]);
			}
			
		} catch(NumberFormatException e) {		//RuntimeException, Exception rksmd
			System.out.println("NumberFormatException");
		} catch(Exception e) { // 예외가 여러개일 경우 계속 사용 가능한다. 단, 순서대로 에러를 찾음.(자식 먼저 배치 후 부모 배치 해야함.)
			System.out.println("Exception 발생");
		}
	}
	
	
	public static void m3() {
		// 어떤 예외가 발생하는지 확인해서
		// try = catch문 넣기 (Exception, RuntimeExceprion은 사용하지 않기)
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("정수 1 >>> ");
			int a = sc.nextInt();								// 정수 입력하지 않았을 때 예외 발생
			System.out.println("정수 2 >>> ");
			int b = sc.nextInt();
			System.out.println(a + "+" + b + "=" + (a + b));
			System.out.println(a + "-" + b + "=" + (a - b));
			System.out.println(a + "*" + b + "=" + (a * b));
			System.out.println(a + "/" + b + "=" + (a / b));	// b가 0일 때 예외 발생
			System.out.println(a + "%" + b + "=" + (a % b));
			sc.close();	
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException 발생");
		} catch(InputMismatchException e) {
			System.out.println("AInputMismatchException 발생");			
		}
	}	
	
	
	public static void m4() {
		try {
			File file = new File("C:\\sample.txt");	  //java io소속 (crtl + space)
			FileReader fr = new FileReader(file);	  // try-catch문이 없으면 실행이 불가능한 Checked Exception   //java io소속 (crtl + space)
		} catch (Exception e) {

		}
		
	}
		
			
	public static void main(String[] args) {
		m4();
		

	}

}
