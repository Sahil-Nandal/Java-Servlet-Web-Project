package com.example.demo5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "displayservlet", value = "/displayservlet")
public class displayservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String str=null;

        String id=null;
        String name=null,book_name=null,author=null;
        try (PrintWriter out = response.getWriter()) {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","");
                PreparedStatement statement = con.prepareStatement("select * from library");
                ResultSet rs = statement.executeQuery();
                out.println("Details of the books listed in the wishlist: ");
                out.println(" ");
                out.println(" ");
                out.println(" ");
                while(rs.next())
                {
                    // str=str+ "<table border='1'> <tr> <td>"+rs.getString(1)+"</td> <td>"+rs.getString(2)+"</td> <td>"+rs.getString(3)+"</td></tr>";
                    id=rs.getString(1);
                    name=rs.getString(2);
                    book_name=rs.getString(3);
                    author=rs.getString(4);

                    str="Reg. No.: "+id+ "   Name: "+name+ "    Book_name: "+book_name+"    Author: "+author;
                    out.println(str);
                    out.println(" ");

                }
                //str=str+"</table>";


                con.close();
            }catch(ClassNotFoundException | SQLException e ){}
            //out.println(str);
            out.println("<h1> Sucess on retrieval</h1>");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
