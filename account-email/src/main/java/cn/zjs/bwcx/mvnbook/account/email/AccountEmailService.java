package cn.zjs.bwcx.mvnbook.account.email;

public interface AccountEmailService {
	
	/**
	 * @param to  接收地址
	 * @param subject  邮件主题
	 * @param htmlText  邮件内容
	 * @throws AccountEmailException 
	 */
	void sendEmail(String to,String subject,String htmlText) throws AccountEmailException;
	
}
