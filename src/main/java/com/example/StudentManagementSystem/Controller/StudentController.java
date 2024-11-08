package com.example.StudentManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Service.StudentService;


@RestController
@CrossOrigin
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    // get all rest api
   @GetMapping("/getAllStudents")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    // Get by Id Rest Api
    @GetMapping("getStudentById/{id}")
    // localhost
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID) {
        return new ResponseEntity<Student>(studentService.getStudentById(studentID), HttpStatus.OK);
    }

    // Update Rest Api
    @PutMapping("getStudentById/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
    return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    // Delete Rest Api
    @DeleteMapping("getStudentById/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
    studentService.deleteStudent(id);
    return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
    }
}


