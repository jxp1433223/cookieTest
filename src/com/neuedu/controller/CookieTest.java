package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //创建一个Cookie对象
        Cookie cookie = new Cookie("username","admin");
        cookie.setMaxAge(60);
        /*设置时间(存储时间默认是秒)*/
        resp.addCookie(cookie);
        req.getRequestDispatcher("ckTest.jsp").forward(req,resp);
    }



}
