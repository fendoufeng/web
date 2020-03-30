package com.example.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/longin_view")){
            return  true;
        }

        Object o = request.getSession().getAttribute("_session_user");
        if (o == null){
            response.sendRedirect("/longin_view");
            return false;
        }

        return true;
    }
}
