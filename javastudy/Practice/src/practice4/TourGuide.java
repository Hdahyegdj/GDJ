package practice4;

public class TourGuide {		// interface 구현 x
	
	
	// 핃드
	private Tour tour;
	
	// 생성자
	public TourGuide(Tour tour) {
		super();
		this.tour = tour;
	}
	
	// 메소드
	public void sightseeing() {
		tour.signhtseeing();
	}
	
	public void leisure() {
		tour.leisure();
	}

}
