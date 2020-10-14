package com.example.webday9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webday9.controller.model.InsertStudentRequest;
import com.example.webday9.controller.model.StudentResponse;
import com.example.webday9.controller.transform.InsertStudentTransform;
import com.example.webday9.controller.transform.StudentTransform;
import com.example.webday9.entity.Student;
import com.example.webday9.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentResponse findById(@PathVariable int id) {
        StudentTransform transform = new StudentTransform();
        Student student = studentService.findById(id);
        return transform.apply(student);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> insert(@RequestBody InsertStudentRequest body) {
        InsertStudentTransform transform = new InsertStudentTransform();
        Student s = transform.apply(body);
        studentService.insert(s);

        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
}
