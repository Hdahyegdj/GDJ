package quiz03_bank;

public class BankException extends Exception {


	private static final long serialVersionUID = 6483585115162653442L; // 에러코드 generate 에서 생성
	private int errorCode;
	
	public BankException(String message, int errorCode) {		// 생성자
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {			//get&set
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	
	


}
