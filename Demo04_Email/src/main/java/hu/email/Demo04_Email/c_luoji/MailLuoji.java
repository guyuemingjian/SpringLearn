package hu.email.Demo04_Email.c_luoji;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 * 
 * @Describe:</br>
 * 				发送邮件</br>
 *
 * @author hu</br>
 * @CreateBy:2018年10月20日</br>
 *
 */
@Service
public class MailLuoji {

	/** 邮件发送人 */
	@Value("${spring.mail.username}")
	private String mailFrom;

	@Autowired
	private JavaMailSender mailSender;

	public void say() {
		System.out.println("hello mail");
	}

	/**
	 * 发送简单文本邮件
	 * 
	 * @param to      发送给谁
	 * @param subject 发送主题
	 * @param content 发送内容
	 */
	public void sendSimpleMail(String to, String subject, String content) {

		SimpleMailMessage message = new SimpleMailMessage();
		// 发送给谁
		message.setTo(to);
		// 发送主题
		message.setSubject(subject);
		// 发送内容
		message.setText(content);
		// 邮件发送人
		message.setFrom(mailFrom);

		// 发送邮件
		mailSender.send(message);
	}

	/**
	 * 发送HTML邮件
	 * 
	 * @param to      发送给谁
	 * @param subject 发送主题
	 * @param content 发送内容
	 * @throws MessagingException
	 */
	public void sendHTMLMail(String to, String subject, String content) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		// 发送给谁
		messageHelper.setTo(to);
		// 发送主题
		messageHelper.setSubject(subject);
		// 发送内容 //富文本模式
		messageHelper.setText(content, true);
		// 邮件发送人
		messageHelper.setFrom(mailFrom);

		// 发送邮件
		mailSender.send(message);
	}

	/**
	 * 发送带附件邮件
	 * 
	 * @param to      发送给谁
	 * @param subject 发送主题
	 * @param content 发送内容
	 * @throws MessagingException
	 * @throws FileNotFoundException 
	 */
	public void sendAddFileMail(String to, String subject, String content, List<String> files)
			throws MessagingException, FileNotFoundException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		// 发送给谁
		messageHelper.setTo(to);
		// 发送主题
		messageHelper.setSubject(subject);
		// 发送内容 //富文本模式
		messageHelper.setText(content, true);
		// 邮件发送人
		messageHelper.setFrom(mailFrom);

		// 添加附件
		for (String f : files) {
			File file = ResourceUtils.getFile(f);
			messageHelper.addAttachment(f, file);
		}

		// 发送邮件
		mailSender.send(message);
	}
}
