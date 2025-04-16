package com.login.servlet;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try {
            JsonObject json = JsonParser.parseString(
                request.getReader().lines().collect(Collectors.joining())
            ).getAsJsonObject();

            String studentId = json.get("studentId").getAsString();
            String studentName = json.get("studentName").getAsString();
            String dob = json.get("dob").getAsString();
            String gender = json.get("gender").getAsString();
            String bloodGroup = json.get("bloodGroup").getAsString();
            String nationality = json.get("nationality").getAsString();
            String admissionNumber = json.get("admissionNumber").getAsString();
            String courseName = json.get("courseName").getAsString();
            String department = json.get("department").getAsString();
            String yearOfAdmission = json.get("yearOfAdmission").getAsString();
            String currentYear = json.get("currentYear").getAsString();

            out.println("Data Received Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}
