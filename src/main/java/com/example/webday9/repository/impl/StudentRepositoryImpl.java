package com.example.webday9.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday9.entity.Student;
import com.example.webday9.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private EntityManager em;

    @Autowired
    public StudentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public void insert(Student s) {
        em.persist(s.getPassport());
        em.persist(s);
    }

}
