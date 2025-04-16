package com.login.dao;

import java.util.List;

import com.login.model.student;

public interface StudentDao {

    boolean saveStudent(student student);      // Save student data
    boolean deleteStudent(String studentId);   // Delete student by ID
    student getStudent(String studentId);      // Get student details using ID
    List<student> getAllStudent();             // Get all students from the database
}
