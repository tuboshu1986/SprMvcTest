package com.hb.spr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 测试拦截器
 */
@Component
public class HelloInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = Logger.getLogger(HelloInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">>>>请求开始");
        return super.preHandle(request, response, handler);
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.info(">>>请求结束");
        super.postHandle(request, response, handler, modelAndView);
    }
}
