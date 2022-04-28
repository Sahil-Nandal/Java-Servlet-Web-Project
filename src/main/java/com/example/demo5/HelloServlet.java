package com.example.demo5;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.sql.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Library Wish List";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1><u>" + message + "</u></h1>");
//        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String id, name, book_name, author, niche;
        double number;
        id = request.getParameter("id");
        name = request.getParameter("name");
        book_name = request.getParameter("book_name");
        author = request.getParameter("author");
        niche = request.getParameter("niche");
        out.println("Data submitted successfully: "+name);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello?autoReconnect=true&useSSL=false", "root", "");
            Statement s = con.createStatement();
            String s1 = "insert into library values ('" + id + "','"+ name +"','"+book_name+"','"+ author +"','"+niche+"');";
//            String s1 = "insert into library(id, name, number, book_name, author, niche) values ('" + id + "','"+ name +"','" + number +"','"+book_name+"','"+ author +"','"+niche+"');";
            s.executeUpdate(s1);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }

//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","");
//
//            PreparedStatement statement = con.prepareStatement("select * from library ");
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()) {
//                rs.getString(1);
//                rs.getString(2);
//                rs.getString(3);
//            }
//            con.close();
//        }catch(Exception e ){}
    }

    public void destroy() {
    }
}