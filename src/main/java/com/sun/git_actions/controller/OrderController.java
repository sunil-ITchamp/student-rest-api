package com.sun.git_actions.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private List<Student> studentList = new ArrayList<>();

    public OrderController(){
        studentList.add(new Student(10L,"Sun"));
        studentList.add(new Student(20L, "Ram"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @PostMapping("/students")
    public Student getStudents(@RequestBody Student student){
        studentList.add(student);
        return student;
    }

}

