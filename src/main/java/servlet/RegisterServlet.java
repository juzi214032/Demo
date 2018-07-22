package servlet;

import bean.UserBean;
import dao.DAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 注册
 * Author: Juzi
 * Time: 2018/7/20 19:36
 * Blog: http://juzibiji.top
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> info = new ArrayList<>();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        UserBean user = new UserBean();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        System.out.println(code);
        if (code.equals(EmailServlet.code.get(email))) {
            if (DAOFactory.getIUserDAOInstance().register(user)) {
                info.add("注册成功，<a href=\"/\">请登录！</a>");
            }else {
                info.add("注册失败了！");
            }
        } else {
            info.add("注册失败，请重试！");
        }
        req.setAttribute("info", info);
        RequestDispatcher rd = req.getRequestDispatcher("/tips.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main.jsp");
    }
}
