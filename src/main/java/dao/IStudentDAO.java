package dao;

import bean.StudentBean;

import java.util.List;

/**
 * Author: Juzi
 * Time: 2018/7/20 16:54
 * Blog: http://juzibiji.top
 */
public interface IStudentDAO {
    int ID = 1;
    int Name = 2;
    int CLASS = 3;
    int PNO = 4;
    int PNAME = 5;
    int COLLEGE = 6;
    int GRADE = 7;
    int XJ = 8;

    /**
     * 增加学生信息
     *
     * @param student 传入的VO对象
     * @return 增加是否成功
     */
    public boolean insert(StudentBean student);

    /**
     * 查找学生信息
     *
     * @param keyWord 查询关键字
     * @param kind    查询类型
     * @return 查询到的结果集合
     */
    public List<StudentBean> find(String keyWord, int kind);

    /**
     * 删除学生信息，用学号确定删除哪一条
     * @param studentId 被删除学生信息中的学号
     * @return 返回删除结果
     */
    public boolean delete(String studentId);
}
