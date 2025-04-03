package com.lpc;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/servletb")
public class servletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {

        System.out.println("servletb");
//        String uname=(String) request.getAttribute("uname");
//        String telphone=(String) request.getAttribute("telphone");

        HttpSession session=request.getSession();
        String uname=(String) session.getAttribute("uname");
        String telphone=(String) session.getAttribute("telphone");

        //获取session域中的name
        Enumeration<String> e=session.getAttributeNames();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
        System.out.println(uname);
        System.out.println(telphone);


    }
}
