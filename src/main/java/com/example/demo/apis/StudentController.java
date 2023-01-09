package com.example.demo.apis;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Student;
import com.example.demo.Services.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping //insert items
    public List<Student>fetchAll(){
        return studentService.getAllStudents();
    }
    // @PostMapping put items
    @GetMapping("/api/v1/getstudents")
    public List<Student>fetchAllStudents(){
        return studentService.getAllStudents();
    }
    
}
