package com.koki.servlet;

import org.apache.jasper.runtime.HttpJspBase;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class cookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastLoginTime")){
                    LocalDateTime time = LocalDateTime.ofInstant
                            (Instant.ofEpochMilli(Long.parseLong(cookie.getValue())), ZoneId.systemDefault());
                    out.write("your last time here:"+time.toString());
                }

            }
        }else {
            out.write("This is the first time here!");
        }
        Cookie cookie = new Cookie("lastLoginTime", Instant.now().toEpochMilli() + "");
        resp.addCookie(cookie);
        //1day
        cookie.setMaxAge(24*60*60);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
