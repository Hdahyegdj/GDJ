package ex13_abstract;

// 추상 메소드   (가 1개라도 있으면 추상 클래스가 됨)
// 1. 본문이 없는 메솓,
// 2. 호출용으로 사용되는 메소드
// 3. 중괄호 자체를 없애고 세미콜론(;)을 추가함.
// 4. public abstract(추천) 또는 abstract public

// 추상 클래스
// 1. 추상 메소드가 1개 이상 존재하는 클래스
// 2. public abstract Class
// 3. 본문이 없는 메소드를 포함하기 때문에 객체 생성이 불허됨.
// 4. 추상 클래스를 상속 받는 클래스는 "반드시" "모든" 추상 메소드를 오버라이드(본문이 없는 메소드를 만들어야) 해야 함.(Circle 참조)


public abstract class Shape {		// 하기에 추상 메소드가 있기 때문에 추상 클래스로 바꾸기 위해 "abstract"를 추가해줘야함.
	
	private String type;

	public Shape(String type) {		// 생성자 생성
		super();
		this.type = type;
	}

	public String getType() {		// get&setter 샐성
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public abstract double getArea(); 		// Shape을 상속 받는 객체들이 호출할 떄 사용하는 메소드
			 								// 사용되지는 않는다. -> 추상 메소드로 바꿔준다.(본문이 없는 메소드)

	
	
	
}
