package com.lpc;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/servleta")
public class servletA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("servleta");
//        request.setAttribute("uname","npc");
//        request.setAttribute("telphone","15229116591");

        HttpSession session=request.getSession();
        session.setAttribute("uname","npc");
        session.setAttribute("telphone","15228116591");

        request.getRequestDispatcher("/servletb").forward(request,response);

    }
}
