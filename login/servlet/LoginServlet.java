package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // 1. Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "gayi64");
         // 3. Create SQL query to check if the user exists
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // 4. Set the parameters for the query
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // 5. Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // 6. Check if the user exists
            if (resultSet.next()) {
//                response.getWriter().println("Login successful!");
            	   // If user exists, redirect to welcome page
                response.sendRedirect("welcome.jsp"); // Redirect to welcome.jsp page

            } else {
                response.getWriter().println("Invalid username or password!");
            }

            // 7. Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
