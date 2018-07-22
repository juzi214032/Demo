package dao;

import bean.UserBean;

/**
 * Author: Juzi
 * Time: 2018/7/20 16:54
 * Blog: http://juzibiji.top
 */
public interface IUserDAO {
    /**
     * 用户登录验证
     * @param user 传入VO对象
     * @return 登录是否成功
     */
    public boolean login(UserBean user);

    /**
     * 用户注册验证
     * @param user 传入VO对象
     * @return 注册是否成功
     */
    public boolean register(UserBean user);

    /**
     * 验证注册用户是否已存在
     * @param username 传入用户名
     * @return 返回验证结果
     */
    public boolean check(String username);
}
