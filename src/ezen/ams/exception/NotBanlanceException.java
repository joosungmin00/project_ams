package ezen.ams.exception;

/**
 *  사용자 정의 예외 클래스
 * @author 주성민
 *
 */
public class NotBanlanceException extends Exception {
//	String message;
	private int errorCode;
	
	public NotBanlanceException() {
		super("예기치 않은 오류가 발생하였습니다. 관리자에게 문의하세요..");
	}
	public NotBanlanceException(String message) {
		super(message);
		
	}
	
	public NotBanlanceException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@Override
		public String toString() {
			return getMessage()+ "에러내용 [에러코드 : ???]";
		}
	
	
	
	
	
	
}
