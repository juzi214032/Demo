package servlet;

import bean.UserBean;
import dao.DAOFactory;
import sun.plugin.com.Dispatcher;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录
 * Author: Juzi
 * Time: 2018/7/20 16:45
 * Blog: http://juzibiji.top
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = true;
        List<String> info = new ArrayList<>();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || "".equals(username)) {
            info.add("账号不能为空！");
        }
        if (password == null || "".equals(password)) {
            info.add("密码不能为空！");
        }
        if (info.size() == 0) {
            UserBean user = new UserBean();
            user.setUserName(username);
            user.setPassword(password);
            if (DAOFactory.getIUserDAOInstance().login(user)) {
                req.getSession().setAttribute("username", username);
                flag = false;
                req.getSession().setAttribute("auth","admin");
                resp.sendRedirect("/main.jsp");
            } else {
                info.add("账号或密码错误！");
            }
        }
        if (flag) {
            req.setAttribute("info", info);
            RequestDispatcher rd = req.getRequestDispatcher("/tips.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main.jsp");
    }
}
