package ex07_override;

public class Americano extends Espresso {
	
	private int extraWater;			 // 필드값 추가 가능
	
	@Override    	//ctrl + space bar로 taste 선택하여 입력 가능  //Source메뉴 Override methods에서 입력 가능
	public void taste() {
		// TODO 해야 할 일을 적어둠.
					// super.taste();  //( 입력이 필요할때 입력하면 됨.)  상속관계에서 super는 부모를 의미. 여기서 super는 상단의 Espresso를 의미.
		System.out.println("덜 쓰다");
	}

}
