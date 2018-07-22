package dao.Impl;

import bean.StudentBean;
import dao.IStudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: Juzi
 * Time: 2018/7/20 17:15
 * Blog: http://juzibiji.top
 */
public class StudentDAOImpl implements IStudentDAO {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;

    public StudentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(StudentBean student) {
        boolean flag = false;
        String sql = "INSERT INTO student values (?,?,?,?,?,?,?,?,?)";
        try {
            this.psmt = this.conn.prepareStatement(sql);
            this.psmt.setInt(1, student.getStudent_id());
            this.psmt.setString(2, student.getName());
            this.psmt.setString(3, student.getSex());
            this.psmt.setString(4, student.getClass_1());
            this.psmt.setInt(5, student.getProfessional_no());
            this.psmt.setString(6, student.getProfessional_name());
            this.psmt.setString(7, student.getCollege());
            this.psmt.setString(8, student.getGrade());
            this.psmt.setString(9, student.getXj());
            int rs = this.psmt.executeUpdate();
            if (rs > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<StudentBean> find(String keyWord, int kind) {
        boolean flag = true;
        List<StudentBean> students = new ArrayList<>();
        int result = 0;
        java.lang.String sql = null;
        switch (kind) {
            case 0:
                sql = "select * from student";
                flag = false;
                break;
            case 1:
                sql = "select * from student where student_id like ?";
                break;
            case 2:
                sql = "select * from student where name like ?";
                break;
            case 3:
                sql = "select * from student where class like ?";
                break;
            case 4:
                sql = "select * from student where professional_no like ?";
                break;
            case 5:
                sql = "select * from student where professional_name like ?";
                break;
            case 6:
                sql = "select * from student where college like ?";
                break;
            case 7:
                sql = "select * from student where sex like ?";
                break;
            case 8:
                sql = "select * from student where xj like ?";
                break;
        }
        try {

            this.psmt = this.conn.prepareStatement(sql);
            if (kind != 0) {
                psmt.setString(1, ("%" + keyWord + "%"));
            }
            this.rs = psmt.executeQuery();
            while (rs.next()) {
                StudentBean studentResult = new StudentBean();
                studentResult.setStudent_id(rs.getInt(1));
                studentResult.setName(rs.getString(2));
                studentResult.setSex(rs.getString(3));
                studentResult.setClass_1(rs.getString(4));
                studentResult.setProfessional_no(rs.getInt(5));
                studentResult.setProfessional_name(rs.getString(6));
                studentResult.setCollege(rs.getString(7));
                studentResult.setGrade(rs.getString(8));
                studentResult.setXj(rs.getString(9));
                students.add(studentResult);
            }
            if (this.psmt != null) {
                this.psmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL异常！");
        }

        return students;
    }

    @Override
    public boolean delete(String studentId) {
        boolean flag = false;
        String sql = "DELETE FROM student WHERE student_id = ?";

        try {
            this.psmt = this.conn.prepareStatement(sql);
            this.psmt.setString(1, studentId);
            int rs = this.psmt.executeUpdate();

            if (rs > 0) {
                flag = true;
            }
            if (this.psmt != null) {
                this.psmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
