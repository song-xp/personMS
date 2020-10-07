package com.lz.interceptor;

import com.lz.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object o) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //除了登录请求外其他的url都进行拦截
        if(url.indexOf("/login") > 0){
            return true;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        //判断session中是否有用户数据，如果有则返回true，继续向下执行
        if(user != null){
            return true;
        }
        //不满足条件的转发到登录界面
        request.setAttribute("msg","你还没有登录，请先登录！");
        request.getRequestDispatcher("jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
