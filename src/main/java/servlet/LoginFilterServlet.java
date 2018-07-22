package servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 权限过滤器
 * 判断是否已经登录了账号
 * 没登录会跳转到首页
 */
/**
 * Author: Juzi
 * Time: 2018/7/21 17:05
 * Blog: http://juzibiji.top
 */
public class LoginFilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String auth = (String) req.getSession().getAttribute("auth");
        if (auth == null || "".equals(auth)) {
            resp.sendRedirect("/");
        }else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
