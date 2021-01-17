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

import com.example.webday9.dto.InsertStudentDTO;
import com.example.webday9.dto.StudentDTO;
import com.example.webday9.entity.Student;
import com.example.webday9.service.StudentService;
import com.example.webday9.transform.StudentTransform;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/{id}")
	public StudentDTO findById(@PathVariable int id) {
		StudentTransform transform = new StudentTransform();
		Student student = studentService.findById(id);
		return transform.apply(student);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> insert(@RequestBody InsertStudentDTO body) {
		StudentTransform transform = new StudentTransform();
		Student s = transform.apply(body);
		studentService.insert(s);

		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
}
