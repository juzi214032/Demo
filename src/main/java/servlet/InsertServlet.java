package servlet;

import bean.StudentBean;
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
 * 增加学生信息
 * Author: Juzi
 * Time: 2018/7/21 13:51
 * Blog: http://juzibiji.top
 */
public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<String> info = new ArrayList<>();
        int student_id = Integer.valueOf(req.getParameter("student_id"));
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String class_1 = req.getParameter("class");
        int professional_no = Integer.valueOf(req.getParameter("professional_no"));
        String professional_name = req.getParameter("professional_name");
        String college = req.getParameter("college");
        String grade = req.getParameter("grade");
        String xj = req.getParameter("xj");

        StudentBean student = new StudentBean();

        student.setStudent_id(student_id);
        student.setName(name);
        student.setSex(sex);
        student.setClass_1(class_1);
        student.setProfessional_no(professional_no);
        student.setProfessional_name(professional_name);
        student.setCollege(college);
        student.setGrade(grade);
        student.setXj(xj);
        //判断数据库中是否有当前学号，如果有，就删除
        if (DAOFactory.getIStudentDAOInstance().find((String.valueOf(student.getStudent_id())), 1).size() > 0) {
            DAOFactory.getIStudentDAOInstance().delete(String.valueOf(student.getStudent_id()));
        }
        if (DAOFactory.getIStudentDAOInstance().insert(student)) {
            info.add("添加成功!");
        } else {
            info.add("添加失败！");
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
