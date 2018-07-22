package dao.proxy;

import bean.StudentBean;
import dao.IStudentDAO;
import dao.Impl.StudentDAOImpl;
import dao.dbc.DatabaseConnection;

import java.util.List;

/**
 * Author: Juzi
 * Time: 2018/7/20 17:44
 * Blog: http://juzibiji.top
 */
public class StudentDAOProxy {
    private DatabaseConnection conn = null;
    private IStudentDAO studentDAO = null;

    public StudentDAOProxy() {
        this.conn = new DatabaseConnection();
        this.studentDAO = new StudentDAOImpl(this.conn.getConn());
    }

    public List<StudentBean> find(String keyWord, int kind) {
        List<StudentBean> result = null;
        result = studentDAO.find(keyWord, kind);
        this.conn.close();
        return result;
    }

    public boolean insert(StudentBean student) {
        boolean flag = false;
        flag = studentDAO.insert(student);
        this.conn.close();
        return flag;
    }

    public boolean delete(String studentId) {
        boolean flag = studentDAO.delete(studentId);
        this.conn.close();
        return flag;
    }

}
