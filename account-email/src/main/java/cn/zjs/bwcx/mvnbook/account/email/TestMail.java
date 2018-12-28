package cn.zjs.bwcx.mvnbook.account.email;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMail {
	
	public static void main(String[] args) throws AccountEmailException {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
		String subject = "Test Subject";
		String htmlText = "<h3>zjs Test send mail first time</h3>";
		accountEmailService.sendEmail("18232529363@163.com", subject, htmlText);
		
	}
}
