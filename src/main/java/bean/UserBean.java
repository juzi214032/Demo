package bean;

/**
 * Author: Juzi
 * Time: 2018/7/20 16:42
 * Blog: http://juzibiji.top
 */
public class UserBean {
    private String userName;
    private String password;
    private String email;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {

        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
