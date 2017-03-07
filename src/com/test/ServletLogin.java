package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by asus on 2017/3/7.
 */
@WebServlet(name = "ServletLogin" ,urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset = gb2312");
        String name = request.getParameter("user");
        String pwd = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println(name);
        out.println(pwd);
        if (name!=null&&pwd!=null&&name.equals("rtq")&&pwd.equals("1234"))
        {
            response.sendRedirect("Success.jsp");
        }
        else
        {
            response.sendError(HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED,"服务器忙，请稍后再试！");
        }
    }
}
