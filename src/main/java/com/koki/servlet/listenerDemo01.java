package com.koki.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数
public class listenerDemo01 implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();//先获取上下文
        Integer count = (Integer) ctx.getAttribute("onlineCount");
        if(count==null){
            count=0;
        }else{
            count+=1;
        }
        ctx.setAttribute("onlineCount",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.invalidate();
    }
}
