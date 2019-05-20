package com.sda.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sda.model.Person;

public class PersonServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 6744760746732105519L;
    
    List<Person> personList = new ArrayList<>();

    @Override
    public void init() {
        System.out.println("Entering init method");

        Person p1 = new Person("barrack", "obama");
        Person p2 = new Person("donald", "trump");
        Person p3 = new Person("klaus", "iohannis");
        Person p4 = new Person("traian", "basescu");

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        System.out.println("Exiting init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entering doGet");

        ServletOutputStream out = resp.getOutputStream();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Person List</h1>");

        out.println("<table border=1px>");
        out.println("<tr><td>FirstName</td><td>LastName</td></tr");
        for (Person p : personList) {
            out.println("<tr><td>" + p.getFirstName() + "</td><td>" + p.getLastName() + "</td></tr>");
        }
        out.println("</table>");

        out.println("<h1>Add person</h1>");
        out.println("<form action=\"/sdaServletApp/getPersons\" method=\"POST\">");
        out.print("FirstName: <input type=\"text\" name=\"firstName\"><br/>");
        out.print("LastName: <input type=\"text\" name=\"lastName\"><br/>");
        out.print("<input type=\"submit\" value=\"Add Person\"><br/>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");

        System.out.println("Exiting doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entering doPost");

        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");

        Person newPerson = new Person(lastName, firstName);

        personList.add(newPerson);
        

        resp.sendRedirect("http://localhost:8080/sdaServletApp/getPersons");

        System.out.println("Exiting doPost");
    }

}
