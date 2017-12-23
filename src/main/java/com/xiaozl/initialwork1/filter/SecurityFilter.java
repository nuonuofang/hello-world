
package com.xiaozl.initialwork1.filter;

        import javax.servlet.*;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

/**
 * Created by user on 2017/12/17.
 * 用户管理权限过滤，只有admin可以访问
 */
public class SecurityFilter  implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setContentType("text/html;charset=utf-8");
        String userName = (String) httpServletRequest.getSession().getAttribute("userName");
        //验证是不是admin
        if("admin".equals(userName)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            httpServletResponse.getWriter().append("哈哈哈，你没有访问权限，略。");
        }
    }

    public void destroy() {

    }
}