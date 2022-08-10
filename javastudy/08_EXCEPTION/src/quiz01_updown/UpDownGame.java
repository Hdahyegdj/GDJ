package quiz01_updown;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {
	
	// 필드
	private int rand; 	   // 1~100 사이 난수
	private int count;     // 시도 횟수
	private Scanner sc; 
	
	// 생성자
	public UpDownGame() {
		// rand, sc 만들기
		
		rand = (int)(Math.random() * 100 + 1);
		sc = new Scanner(System.in);
		
	}
	
	// 입력
	public int input() {
		try { 	
			count ++;
			System.out.print("입력 >>> ");
			int n = sc.nextInt();
			
			if(n < 1 || n > 100) {
				throw new RuntimeException("1 ~ 100 사이 정수만 입력할 수 있습니다.");		// 1~100 외의 숫자를 입력했을떄
			}	
			return n;	
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");		// 한글로 숫자를 입력하거나 정수 외의 문자열을 입력했을때
			sc.next(); // 잘못 입력된 문자열 먹어 치우기
			input(); // 입력 하단 input으로 돌아가 다시 입력시키는 코드(리쿼시블 콜)
			
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			input();
		}
		return 0; // 이클립스 안심시키는 용도(실제로 return코드가 실행되지는 않음)
			
	}
	
	// 실행(맞힐떄까지 무한루프)
	public void play() {
		
		while(true) {

			int n = input();
			
			if(n < rand) {
				System.out.println("Up!");
			} else if (n > rand) {
				System.out.println("Down!");
			} else {
				System.out.println(rand + " 정답입니다. " + count + "번만에 정답");
				break;
			}
		}
	}
}