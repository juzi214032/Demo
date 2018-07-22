package servlet;

import dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 删除信息servlet
 */

/**
 * Author: Juzi
 * Time: 2018/7/21 15:13
 * Blog: http://juzibiji.top
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了删除servt");
        String studentId = req.getParameter("studentId");
        if(DAOFactory.getIStudentDAOInstance().delete(studentId)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main.jsp");
    }
}
