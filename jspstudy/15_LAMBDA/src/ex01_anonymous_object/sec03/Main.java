package ex01_anonymous_object.sec03;

public class Main {

	public static void main(String[] args) {
		
		Soil soil = new Soil();
		
		soil.sellOil();		// Soil에서 작성한 지역변수에 addOil를 통해 기름을 팔 수 있음
		soil.sellOil();		// 주유소에 오면 항상 기름을 판다
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());

	}

};
