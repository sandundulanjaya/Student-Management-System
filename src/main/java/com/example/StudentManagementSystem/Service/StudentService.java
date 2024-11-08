package com.example.StudentManagementSystem.Service;

import java.util.List;

import com.example.StudentManagementSystem.Entity.Student;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id);
    void deleteStudent(long id);
}
