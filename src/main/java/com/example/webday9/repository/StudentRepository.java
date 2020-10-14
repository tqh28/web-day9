package com.example.webday9.repository;

import com.example.webday9.entity.Student;

public interface StudentRepository {

	public Student findById(int id);
	
	public void insert(Student s);
}
