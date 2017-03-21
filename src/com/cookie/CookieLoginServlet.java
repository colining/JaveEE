package com.cookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus on 2017/3/21.
 */
@WebServlet(name = "CookieLoginServlet",urlPatterns = "/CookieLoginServlet")
public class CookieLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String a1 = request.getParameter("username");
                String b1 = request.getParameter("password");
                if (a1.equals("colin"))
                {
                    Cookie userCookie =  new Cookie("user",a1);
                    userCookie.setMaxAge(-1);
                    response.addCookie(userCookie);
                    RequestDispatcher rd =  request.getRequestDispatcher("/CookieWelcomeServlet");
                    rd.include(request,response);
                }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
