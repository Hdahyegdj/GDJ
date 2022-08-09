package practice4;

public class KoreaTour implements Tour {		// interface 구현은 class 만들 때 add버튼 -> 해당 인터페이스 입력(Tour)

	@Override
	public void signhtseeing() {
		System.out.println("광화문");
	}

	@Override
	public void leisure() {
		System.out.println("한강유람선");
	}

}
