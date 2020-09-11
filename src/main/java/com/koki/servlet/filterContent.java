package com.koki.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class filterContent implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("starting");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //编码处理
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        System.out.println("ending");

    }
}
