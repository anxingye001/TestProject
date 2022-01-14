package utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;


public class EmailUtils {

	//参数 email 代表的是注册用户的邮件
	//参数 emailMsg 代表的是发送的信息
	public static void sendMail(String email)
			throws AddressException, MessagingException, GeneralSecurityException, UnsupportedEncodingException {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.host", "smtp.163.com"); //别的邮箱就用别的
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true
		
		//都说qq要进行ssl加密 但是我没用测试也可以  保险使用还是加上了
		/*
		 * MailSSLSocketFactory sf = new MailSSLSocketFactory();
		 * sf.setTrustAllHosts(true); props.put("mail.smtp.ssl.enable", "true");
		 * props.put("mail.smtp.ssl.socketFactory", sf);
		 */
		
		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("l32774971@163.com","XHHDUGIMPZQIQYQU");
			}
		};

		Session session = Session.getInstance(props, auth);
		session.setDebug(true);  //调试使用可以不用加
		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress("l32774971@163.com","昵称","UTF-8")); // 设置发送者以及昵称

		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

		message.setSubject("邮件标题");

		MimeBodyPart text = new MimeBodyPart();
		text.setContent("这是一张图片\n<img src='cid:c.jpg' />","text/html;charset=UTF-8");
		
		MimeBodyPart img = new MimeBodyPart();
		DataHandler dataHandler = new DataHandler(new FileDataSource(new File("D:/aaaa/133.jpg")));
		img.setDataHandler(dataHandler);
		img.setContentID("c.jpg");
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		mimeMultipart.addBodyPart(text);
		mimeMultipart.addBodyPart(img);
		mimeMultipart.setSubType("related");
		message.setContent(mimeMultipart);
		

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
	
	public static void main(String[] args) throws AddressException, MessagingException, GeneralSecurityException, UnsupportedEncodingException {
		sendMail("2381479088@qq.com");
	}
	
}

