package cn.zjs.bwcx.mvnbook.account.email;

public class AccountEmailException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8248592475110264183L;
	
	private String message;
	
	public AccountEmailException(String message) {
		this.message = message;
	}

	public AccountEmailException(String message, Throwable throwable) {
		 super(message, throwable);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
