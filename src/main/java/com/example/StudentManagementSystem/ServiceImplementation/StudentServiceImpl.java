package com.example.StudentManagementSystem.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Repository.StudentRepository;
import com.example.StudentManagementSystem.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentRepository studentRepository;

    //save employee in database
    @Override
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //get all student from database
    @Override
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    //get student by id
    @Override
    public Student getStudentById(long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else{
            throw new RuntimeException();
        }
    }

    //update student
    @Override
    public Student updateStudent(Student student,long id){
        Student existingStudent = studentRepository.findById(id).orElseThrow( ()-> new RuntimeException());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());

        return existingStudent;
    }

    //delete student
    @Override
    public void deleteStudent(long id){
        studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
        studentRepository.deleteById(id);
    }
    
}
