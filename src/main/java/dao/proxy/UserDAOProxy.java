package dao.proxy;
/**
 * UserDAO代理类，负责连接数据库，调用真实类，关闭数据库等操作。
 */

import bean.UserBean;
import dao.IUserDAO;
import dao.Impl.UserDAOImpl;
import dao.dbc.DatabaseConnection;

/**
 * Author: Juzi
 * Time: 2018/7/20 17:43
 * Blog: http://juzibiji.top
 */
public class UserDAOProxy {
    private DatabaseConnection dbc = null;
    private IUserDAO userDAO = null;

    public UserDAOProxy() {
        this.dbc = new DatabaseConnection();
        this.userDAO = new UserDAOImpl(this.dbc.getConn());
    }

    public boolean login(UserBean user) {
        boolean flag = false;
        flag = this.userDAO.login(user);
        this.dbc.close();
        return flag;
    }

    public boolean register(UserBean user) {
        boolean flag = false;
        flag = this.userDAO.register(user);
        return flag;
    }

    public boolean check(String username) {
        boolean flag = false;
        flag = userDAO.check(username);
        if (this.dbc != null) {
            this.dbc.close();
        }
        return flag;
    }
}
