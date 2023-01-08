package com.example.demo.Models;

import org.springframework.data.annotation.Id;

@Data
public class Student {
    @Id
    private String id;
    private String name;
    private String classForm;
}
