package com.example.webday9.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webday9.entity.Student;
import com.example.webday9.repository.PassportRepository;
import com.example.webday9.repository.StudentRepository;
import com.example.webday9.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private PassportRepository passportRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, PassportRepository passportRepository) {
        this.studentRepository = studentRepository;
        this.passportRepository = passportRepository;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public void insert(Student s) {
        passportRepository.insert(s.getPassport());
        studentRepository.insert(s);
    }

}
