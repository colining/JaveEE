package com.cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by asus on 2017/3/21.
 */
@WebServlet(name = "CookieWelcomeServlet",urlPatterns = "/CookieWelcomeServlet")
public class CookieWelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies=  request.getCookies();
        PrintWriter printWriter = response.getWriter();
        printWriter.println("hello ");
           if (cookies!=null &&cookies.length!=0)                   //如果拿到Cookie 就进行下面验证
           {

               for ( int i = 0 ; i<cookies.length ; i++)
               {
                 String a1=  cookies[i].getName();
                 if (a1.equals("user"))
                 {
                     String userkey = cookies[i].getValue().toString();
                     if (userkey.equals("colin"))
                     {
                         PrintWriter printWriter1 = response.getWriter();
                         printWriter1.println("hello "+userkey);
                     }
                 }
               }

           }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
