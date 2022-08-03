package quiz02_coffee;

public class Americano { 		// extends 제거하여 상속 받지 않음.
	
	private Espresso espresso;
	private int shot;
	private String type;
	
	public Americano(Espresso espresso, int shot, String type) {			// 생성자 자동 생성
		super();
		this.espresso = espresso;
		this.shot = shot;
		this.type = type;
	}
	
	public void info() { 		// 호출하기 위해 메소드 입력
		espresso.info();
		System.out.println(shot + "샷");
		System.out.println(type + "아메리카노");
	
	}
	
	
	

	
	
	
	
	

}
