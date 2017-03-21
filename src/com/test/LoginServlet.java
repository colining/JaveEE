package com.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus on 2017/3/14.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //ServletContext context = getServletContext();
        //ServletConfig config = getServletConfig();

        String  a1= getServletConfig() .getInitParameter("username");
        String b1 =  getServletConfig() .getInitParameter("password");
        String a =   request.getParameter("username");
        String b = request.getParameter("password");
        if (a.equals(a1)&& b.equals(b1))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/FirstServlet");
            rd.include(request, response);
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("/ErrorServlet");
            rd.include(request, response);
        }

    }

}

