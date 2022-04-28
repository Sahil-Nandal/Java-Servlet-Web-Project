package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "deleteser", value = "/deleteser")
public class deleteser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str=null;

        String id=null;
        String name=null,book_name=null,author=null;
        id = request.getParameter("regno");
        try (PrintWriter out = response.getWriter()) {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","");
                PreparedStatement statement = con.prepareStatement("delete * from library where id='id'");
                ResultSet rs = statement.executeQuery();
                rs.rowDeleted();
                out.println("Entry deleted successfully!");

                //str=str+"</table>";


                con.close();
            }catch(ClassNotFoundException | SQLException e ){}
            //out.println(str);
            out.println("Success on deletion");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
