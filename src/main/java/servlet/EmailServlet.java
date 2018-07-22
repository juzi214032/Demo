package servlet;

import util.email.SendEmail;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 发送验证邮件
 * Author: Juzi
 * Time: 2018/7/20 19:39
 * Blog: http://juzibiji.top
 */
public class EmailServlet extends HttpServlet {
    public static Map<String, String> code = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //要发送给谁
        String mailTo = null;
        //发送的内容
        String content = null;
        //验证码
        String code = null;

        mailTo = req.getParameter("email");
        code = String.valueOf((int) (Math.random() * 10)) + String.valueOf((int) (Math.random() * 10)) + String.valueOf((int) (Math.random() * 10)) + String.valueOf((int) (Math.random() * 10));
        content = "你的验证码是：" + code;
        try {
            new SendEmail().sendEmail(content, mailTo);
            EmailServlet.code.put(mailTo, code);
            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送邮件失败！！！");
        }

    }
}
