package ex07_constructor;

public class ComputerMain {

	public static void main(String[] args) {
		
		Computer myCom = new Computer("gram", 150);
		myCom.printComputerStatus();    			//Computer package에서 입력한 printComputerStatus가 출력 됨.
		
		Computer yourCom = new Computer();          // Computer에 생성자가 전부 사용하고 있기 떄문에 오류가 남.(overload 규칙을 사용해 한번더 같은 이름의 반환 타입의 생성자를 만들어줘야함.)
		yourCom.printComputerStatus();
		
	}

}
