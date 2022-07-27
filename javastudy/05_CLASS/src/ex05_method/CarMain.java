package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Car car = new Car();
		
		car.addOil(50);
		car.addOil(5);	
		
		car.pushAccel();
		car.pushAccel();
		
		car.pushBrake();
		
		
		//System.out.println("기름" + car.oil);  		 // 50은 int O로 전달.
		//System.out.println("속도" + car.speed);     -> 4번으로 해당 표기 없어도 전체 표시가 가능
		
		car.panel();
		
	}

}
