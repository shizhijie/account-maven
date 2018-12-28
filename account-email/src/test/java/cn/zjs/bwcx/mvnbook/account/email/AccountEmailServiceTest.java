package cn.zjs.bwcx.mvnbook.account.email;

import static org.junit.Assert.assertEquals;

import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest {
	
	private GreenMail greenMail;
	
	@Before
	public void startMailServer() throws Exception{
		greenMail = new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("2272684702@qq.com", "anhfdliurfkoecbc");
		greenMail.start();
	}
	
	@Test
	public void testSendMail() throws Exception{
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
		String subject = "Test Subject";
		String htmlText = "<h3>zjs Test send mail first time</h3>";
		accountEmailService.sendEmail("18232529363@163.com", subject, htmlText);
		greenMail.waitForIncomingEmail(2000,1);
		MimeMessage[] msgs = greenMail.getReceivedMessages();
		//System.out.println(msgs[0].getSubject());
		//System.out.println(GreenMailUtil.getBody(msgs[0]).trim());
		assertEquals(1, msgs.length);
		assertEquals(subject, msgs[0].getSubject());
		assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
	}
	
	@After
	public void stopMailServer() throws Exception{
		greenMail.stop();
	}
}