package dao;

import dao.proxy.StudentDAOProxy;
import dao.proxy.UserDAOProxy;

/**
 * Author: Juzi
 * Time: 2018/7/20 17:50
 * Blog: http://juzibiji.top
 */
public class DAOFactory {
    public static UserDAOProxy getIUserDAOInstance(){
        return new UserDAOProxy();
    }

    public static StudentDAOProxy getIStudentDAOInstance(){
        return new StudentDAOProxy();
    }
}
