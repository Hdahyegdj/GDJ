package ex06_exception_class;

// 사용자 정의 예외 클래스
// Exception  클래스를 상속 받는다.

// Serializable 인터페이스 : 이 인터페이스를 구현하면 직렬화가 가능. serilaVersionUID 값을 가져야 함 (추천)
//
// Throwable 클래스 : serialVersionUId 값이 필요함.
// 
// Exception 클래스 : serialVersionUId 값이 필요함.
//
// MyException 클래스 : serialVersionUId 값이 필요함.




public class MyException extends Exception { 	// 예외

	private static final long serialVersionUID = -7774118171104436322L;		// 에러코드에서 생성
	
	private int errorCode;

	public MyException(String message, int errorCode) {		// 생성자
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {			// get&set (getErrorCode만)
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	} 
	
	
	
	

}
