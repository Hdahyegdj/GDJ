package practice3;

public class Bakery {
	
	// 필드
	private int price; 	 // 빵가게
	private int cnt; 	 // 빵개수
	private int money; 	 // 자본금

	// 생성자(source menu)
	public Bakery(int price, int cnt, int money) {
		super();
		this.price = price;
		this.cnt = cnt;
		this.money = money;
	}
	
	
	// 판매 (메소드)
	public BreadAndChange sell(int custMoney) {
										//   ㄴ> (throws RuntimeException) 생략 가능 하다.
		
		// 판매 불가
		if(custMoney < price) { // 판매 가격보다 지불 금액이 작을때
			throw new RuntimeException("판매 불가");
		}
	
		// 판매 할 수 있는 빵은 몇 개인가?
		int sellCnt = custMoney / price;
		
		// 잔돈은 얼마인가?
		int change = custMoney % price;
		
		// 매장 내부의 변화 처리
		cnt -= sellCnt; 	// 빵개수는 팔린 개수만큼 줄어든다.
		this.money += (custMoney - change); 	// this.money는 필드머니(자본금)	// 자본금은 고객들이 지불한 금액에서 잔돈은 뺀 금액
		
		// 고객에게 되돌려 줄 빵과 잔돈
		return new BreadAndChange(sellCnt, change);	 //BreadAndChange ctrl + space로 입력
	}
	
	
	// 정보 확인 (메소드_
	public void info() {
		System.out.println("빵 " + cnt + "개, 자본금 " + money + "원");
		
	}

}
