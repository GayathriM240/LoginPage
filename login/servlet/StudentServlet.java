package com.login.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.StudentDao;
import com.login.dao.impl.StudentDaoImpl;
import com.login.model.student;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public StudentServlet() {
        super();
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("save".equalsIgnoreCase(action)) {
            saveStudent(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            deleteStudent(request, response);
        } else if ("view".equalsIgnoreCase(action)) {
            viewAllStudents(request, response);
        } else {
            response.getWriter().println("Invalid action!");
        }
    }

    // Save Student Data
    private void saveStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            student student = new student();
            student.setStudentName(request.getParameter("studentName"));
            student.setDob(request.getParameter("dob"));
            student.setGender(request.getParameter("gender"));
            student.setBloodGroup(request.getParameter("bloodGroup"));
            student.setNationality(request.getParameter("nationality"));
            student.setStudentId(request.getParameter("studentId"));
            student.setAdmissionNumber(request.getParameter("admissionNumber"));
            student.setCourseName(request.getParameter("courseName"));
            student.setDepartment(request.getParameter("department"));
            student.setYearOfAdmission(Integer.parseInt(request.getParameter("yearOfAdmission")));
            student.setCurrentYear(request.getParameter("currentYear"));

            boolean isSaved = studentDao.saveStudent(student);
            if (isSaved) {
                response.getWriter().println("Student details saved successfully!");
            } else {
                response.getWriter().println("Failed to save student details.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // Delete Student Data
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("studentId");
        try {
            boolean isDeleted = studentDao.deleteStudent(studentId);
            if (isDeleted) {
                response.getWriter().println("Student deleted successfully!");
            } else {
                response.getWriter().println("Failed to delete student. Student ID not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // View All Students Data
    private void viewAllStudents(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("ViewAllStudents method called");

        try {
            List<student> studentList = studentDao.getAllStudent();
            System.out.println("Fetched " + studentList.size() + " students from the database.");

            request.setAttribute("studentList", studentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewStudent.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("view".equalsIgnoreCase(action)) {
            viewAllStudents(request, response);
        } else {
            response.getWriter().println("Invalid action!");
        }
    }
}
