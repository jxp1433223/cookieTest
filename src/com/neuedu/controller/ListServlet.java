package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.pojo.Product;
import com.neuedu.pojo.User;
import com.neuedu.service.IProductService;
import com.neuedu.service.IUserService;
import com.neuedu.service.ProductServiceImpl;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    private IUserService uservice= new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies=req.getCookies();
        Map<String,Cookie>maps=getCookie(cookies);
        Cookie coo=maps.get("username");
        String uname=coo.getValue();
        HttpSession session=req.getSession();
        User u=(User) session.getAttribute("user");
        if(u==null){
            User user=uservice.getOne(uname);
            session.setAttribute("user",user);
            List<Product> lists = service.getLists();
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }

       /* String lis= JSONObject.toJSONString(lists);*/
       /* resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(lis);*/

    }
    public static Map<String,Cookie>getCookie(Cookie[] cookies){
       Map<String,Cookie>maps=new HashMap<>();
        if (cookies!=null){
            for (Cookie coo:cookies
                 ) {
                maps.put(coo.getValue(),coo);
            }
        }
                return maps;
    }
}
