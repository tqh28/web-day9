package com.example.webday9.service;

import com.example.webday9.entity.Student;

public interface StudentService {

    public Student findById(int id);

    public void insert(Student s);
}
