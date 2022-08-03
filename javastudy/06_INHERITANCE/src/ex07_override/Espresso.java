package ex07_override;

public class Espresso extends Coffee{
					//--------------> 추가 입력
	
	@Override             // override하기 위해서는 슈퍼클래스와 서브클래스가 동일한 메소드로 생성해야함.
	public void taste() {
		System.out.println("쓰다");
	}

}
