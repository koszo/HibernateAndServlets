package com.sda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 2318775345151222245L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Header1</h1>");
        out.println("<h2>Header2</h2>");
        out.println("</body>");
        out.println("</html>");

    }

}
