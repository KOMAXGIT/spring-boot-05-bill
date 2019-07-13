package com.menxuegu.springboot.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerIntercepter implements HandlerInterceptor {
    /**
     * 调用目标方法之前被拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       Object loginUser= request.getSession().getAttribute("loginUser");
        if(loginUser !=null){
            return true;
        }
        request.setAttribute("msg","无权限请先登入");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
