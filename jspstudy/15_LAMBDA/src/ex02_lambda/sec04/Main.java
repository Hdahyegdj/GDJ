package ex02_lambda.sec04;

public class Main {

	public static void main(String[] args) {
		
		Soil soil = new Soil();
		soil.sellOil(() -> {
			int oil = 30;
			soil.setTotalOil(soil.getTotalOil() - oil);		// class外部接近はGET＆SETのみ
			soil.setEarning(soil.getEarning() + oil + soil.getPayPerLiter());
			System.out.println("감사합니다. 소나타");	
		});		// 하단과 동일 코드
		
		soil.sellOil(new Car() {	
			@Override
			public void addOil() {
				int oil = 30;
				soil.setTotalOil(soil.getTotalOil() - oil);		// class外部接近はGET＆SETのみ
				soil.setEarning(soil.getEarning() + oil + soil.getPayPerLiter());
				System.out.println("감사합니다. 소나타");	
			}	//　車が来るたびに計算(익명객체)
		});
		
		
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());

	}

};
