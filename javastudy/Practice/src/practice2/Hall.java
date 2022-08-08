package practice2;

public class Hall {
	
	private String hallName; 	// 홀이름
	private SeatGroup[] seatGroups;
	private Scanner sc;
	private String[] seatTypes = {"5", "R", "A"};
	private int[] seatCount = {20, 30, 40};
	
	public Hall(String hallName) {
		this.hallName = hallName;
		seatGroups = new SeatGroup[seatTypes.length]; 	// S, R, A석이 있음을 의미
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i] = new SeatGroup(seatTypes[i], seatCount[i]);
		}
		sc = new Scanner(System.in);
	}

	
	
	
	
	
	
}
