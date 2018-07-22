package dao.Impl;

import bean.UserBean;
import dao.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Juzi
 * Time: 2018/7/20 17:01
 * Blog: http://juzibiji.top
 */
public class UserDAOImpl implements IUserDAO {
    private Connection conn = null;
    private PreparedStatement psmt = null;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean login(UserBean user) {
        boolean flag = false;
        String sql = "SELECT userid FROM user where userid =? and password=?";
        try {
            this.psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getUserName());
            psmt.setString(2, user.getPassword());
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
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

    @Override
    public boolean register(UserBean user) {
        boolean flag = false;
        String sql = "insert into user(userid,password,email) values (?,?,?)";
        try {
            this.psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getUserName());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getEmail());
            int rs = psmt.executeUpdate();
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

    @Override
    public boolean check(String username) {
        boolean flag = false;
        String sql = "SELECT username FROM user WHERE username = ?";

        try {
            this.psmt = this.conn.prepareStatement(sql);
            this.psmt.setString(1, username);
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
