package com.lpc.servlet;

import com.alibaba.fastjson.JSON;
import com.lpc.pojo.Emp;
import com.lpc.service.EmpService;
import com.lpc.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/emp/*")
public class EmpServlet extends HttpServlet {

    private final EmpService empService = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("请求到了 EmpServlet：" + request.getRequestURI());
        String uri = request.getRequestURI();
        if (uri.endsWith("/list")) {
            List<Emp> all = empService.getAll();
            writeJson(response, all);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        try {
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            Emp emp = JSON.parseObject(sb.toString(), Emp.class);

            if (uri.endsWith("/add")) {
                empService.add(emp);
                writeJson(response, "添加成功");
            } else if (uri.endsWith("/update")) {
                empService.update(emp);
                writeJson(response, "修改成功");
            } else if (uri.endsWith("/delete")) {
                empService.delete(emp.getEmpno());
                writeJson(response, "删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();  // ✅ 打印异常信息
            response.setStatus(500);
            writeJson(response, "服务端异常：" + e.getMessage());
        }
    }

    private void writeJson(HttpServletResponse response, Object data) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(data));
        out.close();
    }
}
