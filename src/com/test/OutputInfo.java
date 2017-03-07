package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by asus on 2017/3/7.
 */
@WebServlet(name = "OutputInfo" ,urlPatterns = "/OutputInfo")
public class OutputInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset= gb2312");
        PrintWriter out = response.getWriter();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String name = (String)headerNames.nextElement();
            String value = request.getHeader(name);
            out.println("<td>"+name+"</td>");
            out.println("</tr>");
            out.println("<td>"+value+"</td>");
            out.println("</br>");
            out.println("</tr>");

        }

    }
}
