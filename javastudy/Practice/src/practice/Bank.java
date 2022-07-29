package practice;

public class Bank {

	// 필드 
	private String accNo;
	private long balance;
	
	// 생성자
	public Bank(String accNo, long balance) {	// Bank b = new Bank("1234", 500000)      Bank 타입의 객체 b를  
		this.accNo = accNo;
		this.balance = balance;
	}
	
	
	// 1. 입금(마이너스 입금 불가)
	public void deposit(long money) {	// b.deposit(50000)을 줌 
		if(money <= 0) {
			return;						//반환타입이 void인 메소드를 종료하는 코드
		}
		balance += money;	
	}
	
	
	// 2. 출금(마이너스 출금 + 잔액보다 큰 출금 불가)
	// 실제로 출금된 금액을 반환
	public long withdrawal(long money) {	// long 출금액 = b.w withdrawal(50000);  50000만원 출금 요청 했는데, 출근 된 경우와 출금되지 않은 경우 두가지 메소드를 설계해야함.
		if(money <= 0 || money > balance) {    // money값이 0보다 작거나 또는(||) balance보다 작을때 
			return 0; 						   // 반환값은 0이다.
		}
		balance -= money;
		return money;
	}
	
	
	// 3. 이체(출금 -> 입금)
	public void transfer(Bank other, long money) {   //다른 사람에게 얼마를 이체 할 건지 (Bank other : 이체 보낼 사람, long money : 얼마)
		// 내 통장에서 출금된 금액만큼 상대 계좌에 입금한다.
		// long withdrawalMoney = withdrawal(money);	
		// other.deposit(withdrawalMoney);
		other.deposit(withdrawal(money));	// 괄호 안에 내용이 먼저 실행되고, 다음에 deposit 내용이 실행		
	}
	
	
	// 4. 계좌 정보 확인
	public void accInfo() {
		System.out.println("계좌정보 : " + accNo + ". 잔액 : " + balance + "원");
	}
	
	
	// 5. 메인
	public static void main(String[] args) {        //main + ctrl + space로 입력 가능
		
		Bank me = new Bank("1234", 50000);
		Bank mom = new Bank("4567", 100000);
		
		mom.transfer(me, 500);   // 엄마가 나에게 5만원 이체한다.

		me.accInfo();
		mom.accInfo();
		
		
	}
	
	

}
