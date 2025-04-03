package com.lpc.servlet;

import com.lpc.controller.UserController;
import com.lpc.pojo.Users;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserController userController = new UserController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String phone = req.getParameter("phone");
        // 暂不校验验证码
        Users user = userController.selectByTelphone(phone);

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (user != null) {
            req.getSession().setAttribute("user", user);
            out.write("{\"status\": \"success\", \"userId\": " + user.getUser_id() + "}");
        } else {
            out.write("{\"status\": \"fail\", \"msg\": \"手机号未注册\"}");
        }
    }
}

