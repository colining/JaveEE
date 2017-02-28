package com.test;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by asus on 2017/2/28.
 */

public class test  implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
      PrintWriter out =  servletResponse.getWriter();
     String  a= servletRequest.getParameter("username");
      out.println("hello "+a);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
