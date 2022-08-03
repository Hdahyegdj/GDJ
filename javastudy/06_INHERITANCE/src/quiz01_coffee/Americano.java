package quiz01_coffee;

public class Americano extends Espresso {
	
	private String type;  // hot과 ice 종류가 있다.

	public Americano(String origin, int water, String type) {		//생성자 생성
		super(origin, water);
		this.type = type;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println(type + "아메리카노");
	}
	
	
	
	
	
	

}
