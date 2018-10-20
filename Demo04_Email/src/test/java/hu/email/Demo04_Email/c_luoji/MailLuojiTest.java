package hu.email.Demo04_Email.c_luoji;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailLuojiTest {

	@Autowired
	private MailLuoji mail;

	@Ignore
	public void testSay() {
		mail.say();
	}

	@Ignore
	public void testSendSimpleMail() {
		String to = "906656770@qq.com";
		String subject = "测试简单文本邮件";
		String content = "这是用来测试简单文本邮件的信息";
		mail.sendSimpleMail(to, subject, content);
	}

	@Ignore
	public void testSendHTMLMail() throws MessagingException {
		String to = "906656770@qq.com";
		String subject = "测试HTML邮件";
		String content = "<html>\n" + "<body>\n" + "	<h2>Hello World!</h2>\n" + "\n"
				+ "	<a href=\"/springBoot/hello3/1\">href=/springBoot/hello3/1 </a>\n"
				+ "	<form action=\"./postform\" method=\"post\">\n"
				+ "		<label>c1:</label> <input type=\"text\" name=\"c1\" id=\"c1\" /><br/> \n"
				+ "		<label>c2:</label> <input type=\"text\" name=\"c2\" id=\"c2\" /><br/>\n" + "		<hr/>\n"
				+ "		<input type=\"submit\" />\n" + "	</form>\n" + "	\n" + "	<label>${test.c1}</label>\n"
				+ "	<label>${test.c2}</label>\n" + "</body>\n" + "</html>\n";

		mail.sendHTMLMail(to, subject, content);
	}

	@Test
	public void testSendAddFileMail() throws MessagingException, IOException {

		
		
		List<String> files = new ArrayList<>();
		files.add("classpath:static/img/" +"large_chart.png");
		files.add("classpath:static/img/" +"large_clipart.png");

		String to = "906656770@qq.com";
		String subject = "测试带附件邮件";
		String content = "这是用来测试附件邮件的信息";
		mail.sendAddFileMail(to, subject, content, files);
	}
}
