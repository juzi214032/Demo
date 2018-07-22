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
 * 查询学生信息
 * Author: Juzi
 * Time: 2018/7/21 10:53
 * Blog: http://juzibiji.top
 */
public class FindServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<StudentBean> result = null;
        int kind = 0;
        String keyWord = null;
        switch (req.getParameter("kind")){
            case "显示全部" :
                kind=0;
                break;
            case "姓名" :
                kind=2;
                break;
            case "学号" :
                kind=1;
                break;
            case "班级" :
                kind=3;
                break;
            case "专业号" :
                kind=4;
                break;
            case "专业名" :
                kind=5;
                break;
            case "学院" :
                kind=6;
                break;
            case "性别" :
                kind=7;
                break;
        }
        keyWord = req.getParameter("keyword");
        result = DAOFactory.getIStudentDAOInstance().find(keyWord, kind);
        req.setAttribute("result", result);
        RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main.jsp");
    }
}
