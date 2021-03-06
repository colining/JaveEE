package com.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by asus on 2017/3/14.
 */
@WebServlet(name = "ContextInfoServlet" ,urlPatterns = "/ContextInfoServlet")
public class ContextInfoServlet extends HttpServlet
{
    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext ctx = getServletContext();

        out.println("<HTML>\n");
        out.println("<HEAD><TITLE>Context Infomation</TITLE></HEAD>\n");
        out.println("<BODY>\n");
        out.println("<h3 align=\"center\">Information About ServletContext</h3>\n");
        out.println("<hr/>\n");

        out.println("ServletContext.getMajorVersion() = " + ctx.getMajorVersion() + " <BR/>\n");
        out.println("ServletContext.getMinorVersion() = " + ctx.getMinorVersion() + " <BR/>\n");
        out.println("ServletContext.getServerInfo() = " + ctx.getServerInfo() + " <BR/>\n");
        out.println("ServletContext.getRealPath(\"/index.html\") = " + ctx.getRealPath("/index.html") + " <BR/>\n");

        out.println("</BODY>\n");
        out.println("</HTML>");
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        doGet(request, response);
    }
}