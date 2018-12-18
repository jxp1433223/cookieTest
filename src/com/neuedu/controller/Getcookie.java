package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/coo/getCookie")
public class Getcookie  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies =req.getCookies();
        HttpSession session= req.getSession();
        session.setMaxInactiveInterval(20);
/*        session.getId();*/
        for (Cookie c:cookies
             ) {
            System.out.println(c.getName());
            System.out.println(c.getValue());

        }

    }
}
