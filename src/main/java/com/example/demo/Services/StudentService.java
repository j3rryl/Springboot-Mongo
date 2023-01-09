package com.example.demo.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Student;
import com.example.demo.Repos.StudentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
