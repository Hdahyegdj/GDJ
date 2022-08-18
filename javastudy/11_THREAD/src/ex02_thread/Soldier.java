package ex02_thread;

public class Soldier extends Thread {
	
	private String name;
	private Gun gun;
	
	public Soldier(String name, Gun gun) {		// 생성자
		super();
		this.name = name;
		this.gun = gun;
	}
	
	public void shoot() {
		System.out.print(name + " : ");
		gun.shoot();
	}
	
	@Override		//ctrl + space를 통해 override run선택
	public void run() {		// gun.bullet에서는 남은 총알 갯수 확인이 어려움으로 get&setter를 만들어줘야함.
		
		// 1초에 한 발씩 쏘기
		try {
			while(gun.getBullet() != 0) {
				shoot();
				Thread.sleep(1000);		// thread sleep 사용을 위해 try catch 사용이 필요함
			} 
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
