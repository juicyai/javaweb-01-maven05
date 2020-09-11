package com.koki.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import static java.awt.Font.ITALIC;

public class ImageSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //设置编码
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
        //每5s刷新一次界面
        resp.setHeader("refresh","5");

        //在内存中创建图片
        BufferedImage bi=new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) bi.getGraphics();
        graphics.setBackground(Color.PINK);
        graphics.setFont(new Font(null, ITALIC,20));
        graphics.drawString(createNums(),0,20);
        //设置图片响应格式
        resp.setContentType("image/jpg");
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragna","no-cache");

        //把图片写给浏览器
        ImageIO.write(bi,"jpg",resp.getOutputStream());

    }
    private String createNums(){
        Random random = new Random();
        String s=random.nextInt(99999999)+"";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7-s.length(); i++) {
            sb.append("0");
        }
        return s+sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
