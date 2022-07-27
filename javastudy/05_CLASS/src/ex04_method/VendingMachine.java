package ex04_method;

public class VendingMachine {
	
	String getCoffee(int money, int button) {                 //이해하기
		
		String[] menu = {"아메리카노", "카페라떼"};
		return menu[button - 1] + " " + (money / 1000) + "잔";  
		          //----------->커피 종류
		
		// String[] menu = {"아메리카노", "카페라떼"};
		// return menu[button] + " " + (money / 1000) + "잔"; 
		
	}

}
