package practice2;

public class Seat {
	
	private String name; 	// 시트 예약한 사람이름
	
	
	// 예약한 사람 확인
	public String getName() {
		return name;
	}

	// 예약
	public void reserve(String name) {		//setter -> reserve로 변경하여 알기쉽게 해줌.
		this.name = name;
	}
	
	// 예약 취소
	public void cancel() {
		name = null;
	}
	
	// 예약 여부 확인
	public boolean isOccupied() {
		return name != null; 	// null이 아니면(예약을 한 상태) true 반환(예약되어있으면 true 반환)
	}
	
	// 예약자 확인
	public boolean isMatched(String name) {		// 받아온 이름과 저장된 이름 일치 유무
		return name.equals(this.name);	 // 확인을 위해 받아온 이름 : name, 저장된 이름 : this name
	}
	
	
	
	

}
