package ex04_input;

import javax.swing.JOptionPane;

public class Ex01_JOptionPane {

	public static void main(String[] args) {
		
		// javax.swing.JOptionPane 클래스    (x는 확장의 의미)
		// GUI 툴을 제공하는 클래스 
		
		String name = JOptionPane.showInputDialog("이름을 입력하세요");     //전부 자동 완성으로 입력. //객체(클래스) 생성없이 만듬.(showInput..)
		String age = JOptionPane.showInputDialog("나이를 입력하세요");
		
		System.out.println(name);
		System.out.println(age);
		
		
	

		
		
		
	}

}
