package com.example.miniproject.controller;

import com.example.miniproject.models.Student;
import com.example.miniproject.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

//    @PostMapping("/student")
//    public String addStudent(@RequestBody Student student) {
//        studentRepository.save(student);
//        return "Saved data of " + student.getName();
//    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return studentRepository.findById(id);
    }

    @PutMapping("/student")
    public String updateStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Updated data of " + student.getName();
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable int id) {
        studentRepository.deleteById(id);
        return "Deleted data";
    }
}
