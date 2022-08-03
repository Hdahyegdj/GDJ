package quiz02_coffee;

public class Espresso extends Coffee {
	
	private int water;

	public Espresso(String origin, int water) {  //origin: 케냐, water: 50
		super(origin);
		this.water = water;
	}
	
	@Override
	public void info() {
		super.info();	// 케냐 출력
		System.out.println("물 " + water + "ml");	// 물 출력
	}
	

}
