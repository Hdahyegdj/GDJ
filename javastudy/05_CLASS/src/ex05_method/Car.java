package ex05_method;

public class Car {

	// 필드	
	int oil;
	int speed;
	
	// 메소드
	
	// 1. 기름 넣기
	// 반환타입 : void(반환값이 없다)
	// 메소드명 : addOil
	// 매개변수 : int o
	void addOil(int o) {
		oil += o;   				// oil에 들어오는 기름을 더해주기
	}
		
	// 기름 한도가 60일 떄	
	// void addOil(int o) {
	//	 oil += o;
	//	 if(oil > 60) {
	//		oil = 60;
		
		
	// 2. 달리기
	// 반환타입 : void
	// 메소드명 : pushAccel
	// 매개변수 : X
	void pushAccel() {
		if(oil == 0) {
			return;     //반환타입이 void일때만 사용 가능한 (상기 코드 실행을 막아주는)코드
		}
		if(speed == 120) {
			oil--;
			return; 
		}
		// 속도는 25씩 증가, 최대속도 120
		// 기름은 1씩 사용
		speed += 25;
		if(speed > 120) {
			speed = 120;
		}
		oil -= 1;    // oil--;  (1씩 줄어들기 때문에 동일 표현)
	}
	
	// 3. 멈추기
	// 반환타입 : void
	// 메소드명 : pushBrake
	// 매개변수 : X
	void pushBrake() {
		if(speed == 0) {
			return;
		}
		speed -= 25;
		if(speed < 0) {
			speed = 0;         // speed가 0보다 작으면 0으로 설정.
		}
	}
	
	// 4. 계기판(기름, 속도) 확인
	// 반환타입 : void
	// 매소드명 : panel
	// 매게변수 : X
	void panel() {
		System.out.println("기름 " + oil);
		System.out.println("속도 " + speed);
		
	}
		
	
	
	
}
