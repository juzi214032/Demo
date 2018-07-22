package dao.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author: Juzi
 * Time: 2018/7/20 16:45
 * Blog: http://juzibiji.top
 */
public class DatabaseConnection {
    private static final String DBDRRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBUSER = "***";
    private static final String DBPASSWORD = "***";
    private static final String DBURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=Asia/Shanghai";
    private Connection conn = null;

    public DatabaseConnection() {
        try {
            Class.forName(DBDRRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载JDBC驱动出错！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取数据库连接出错！");
        }

    }

    public Connection getConn() {
        return conn;
    }

    public void close(){
        if(this.conn!=null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭数据库连接出错！");
            }
        }
    }
}
