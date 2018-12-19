package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        User user = service.getOne(uname);
        if (user!= null){
       if(user.getPassword().equals(pwd)){

           Cookie coo=new Cookie("username",uname);
           Cookie coop=new Cookie("password",pwd);
           coo.setMaxAge(60*60*7);
           coop.setMaxAge(60*60*7);
           resp.addCookie(coo);
           resp.addCookie(coop);
           HttpSession session=req.getSession();
           session.setAttribute("user",user);
           resp.sendRedirect("list");

           }
        }
    }
}
