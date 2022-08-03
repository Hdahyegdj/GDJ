package quiz03_bus;

public class Bus {

	private Seat[] seats;	 //배열 선언(좌석이 여러개 있는 버스)
	private int limit;		 //버스 정원
	
	// Bus 생성자에서 배열 생성을 진행함.
	public Bus(int cnt) {
		seats = new Seat[cnt]; 	//배열 생성. new Bus(25)인 경우 Seat가 25개 생성됨.
		limit = cnt;
		for(int i = 0; i < cnt; i++) {
			seats[i] = new Seat();
		}
	}
 	
	
	// ride() 메소드
	public void ride(int seatNo, Person person) {  	//모든 매개변수인 Person을 사용
		//존재하지 않는 시트번호
		if(seatNo <= 0 || seatNo > limit) {
			return;		//ride() 메소드 종료
		}
		
		// 시트에 사람이 없으면, 시트번호에 Person 저장하기
		Seat seat = seats [seatNo - 1];
		Person p = seat.getPerson();
		if(p == null) {
			seat.setPerson(person);			//setPerson으로 사람 앉히기
		}
	}	
		/* 상기 식와 동일
		if(seats[seatNo - 1] getPerson() == null) { 	//자리가 공석이면 null에 집어넣자.
										    // Seat[] seats = new Seat[25];  ---> null만 25개
			seats[seatNo -1].setPerson(person);   //좌석번호는 1~25이기 때문에 배열값으로 변환하기 위해 0~24로 만들어줌
		}	
	} */
	
	
	//info() 메소드
	public void info() {
		for(int i = 0; i < limit; i++) { 	//limit은 seats 배열의 length와 같음
			Seat seat = seats[i];
			Person person = seat.getPerson(); 	//Person person = seat[i].getPerson(); 
			if(person != null) { 	// if(seat.getPerson() != null), if(seats[i].getPerson() != null)   // (좌석이 비어있지 않으면)
				System.out.println((i + 1) + "," + person.getName());	//i값이 0부터 이니까 +1를 통해 좌석 번호 나타냄.
					// System.out.println((i + 1) + "," + seat.getPerson().getName());
					// System.out.println((i + 1) + "," + seat[i].getPerson().getName());				
			} else {
				System.out.println((i + 1) + ", 비어있음");
			}
			
			
		
	}
	
}
	
}
