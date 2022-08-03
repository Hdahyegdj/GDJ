package ex08_override;

public class Square extends Rectangle {

	public Square(String type, double width) {		//필드값이 없을 때, ...from super class메뉴에서 생성자를 생성 가능
		super(type, width, width);		//너비값만 받아와 super class의 너비와 높이로 사용한다.
	}
	

}
