package util.email;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 这个类中需要设置邮箱协议（SMTP）
 * SMTP服务器
 * SMTP端口
 *以及你自己的账号和授权码（不是邮箱登录密码！！！）
 * Author: Juzi
 * Time: 2018/7/20 20:01
 * Blog: http://juzibiji.top
 */
public class SendEmail {
    public void sendEmail(String content,String mailTo) throws MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        props.setProperty("mail.smtp.port", "587");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        //超时时间
        props.setProperty("mail.smtp.timeout","10000");
        // 验证账号及密码，密码需要是第三方授权码（注意不是邮箱账号的密码！！！）
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("****@qq.com", "****");
            }
        };
        Session session = Session.getInstance(props, auth);
        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        // 设置发送者
        message.setFrom(new InternetAddress("****@qq.com"));
        // 设置发送方式与接收者
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mailTo));
        // 设置主题
        message.setSubject("Demo验证码");
        // 设置内容
        message.setContent(content, "text/html;charset=utf-8");
        // 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }
}
