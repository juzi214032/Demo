package servlet;

import bean.StudentBean;
import dao.DAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 修改信息Servlet
 * Author: Juzi
 * Time: 2018/7/21 16:16
 * Blog: http://juzibiji.top
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        List<StudentBean> results = DAOFactory.getIStudentDAOInstance().find(studentId, 1);
        StudentBean student = results.get(0);


        req.setAttribute("student", student);
        RequestDispatcher rd = req.getRequestDispatcher("/edit.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main.jsp");
    }
}
