package com.login.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.login.dao.StudentDao;
import com.login.model.student;
import com.login.util.DBConnection;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean saveStudent(student student) {
        String sql = "INSERT INTO Student (studentId, studentName, dob, gender, bloodGroup, nationality, admissionNumber, courseName, department, yearOfAdmission, currentYear) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set values to SQL query using PreparedStatement
            preparedStatement.setString(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setDate(3, java.sql.Date.valueOf(student.getDob()));
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getBloodGroup());
            preparedStatement.setString(6, student.getNationality());
            preparedStatement.setString(7, student.getAdmissionNumber());
            preparedStatement.setString(8, student.getCourseName());
            preparedStatement.setString(9, student.getDepartment());
            preparedStatement.setInt(10, student.getYearOfAdmission());
            preparedStatement.setString(11, student.getCurrentYear());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(String studentId) {
        String sql = "DELETE FROM Student WHERE studentId = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, studentId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public student getStudent(String studentId) {
        String sql = "SELECT * FROM Student WHERE studentId = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student student = new student();
                student.setStudentId(resultSet.getString("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setDob(resultSet.getDate("dob").toString());
                student.setGender(resultSet.getString("gender"));
                student.setBloodGroup(resultSet.getString("bloodGroup"));
                student.setNationality(resultSet.getString("nationality"));
                student.setAdmissionNumber(resultSet.getString("admissionNumber"));
                student.setCourseName(resultSet.getString("courseName"));
                student.setDepartment(resultSet.getString("department"));
                student.setYearOfAdmission(resultSet.getInt("yearOfAdmission"));
                student.setCurrentYear(resultSet.getString("currentYear"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<student> getAllStudent() {
        List<student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM Student";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                student student = new student();
                student.setStudentId(resultSet.getString("studentId"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setDob(resultSet.getDate("dob").toString());
                student.setGender(resultSet.getString("gender"));
                student.setBloodGroup(resultSet.getString("bloodGroup"));
                student.setNationality(resultSet.getString("nationality"));
                student.setAdmissionNumber(resultSet.getString("admissionNumber"));
                student.setCourseName(resultSet.getString("courseName"));
                student.setDepartment(resultSet.getString("department"));
                student.setYearOfAdmission(resultSet.getInt("yearOfAdmission"));
                student.setCurrentYear(resultSet.getString("currentYear"));

                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
