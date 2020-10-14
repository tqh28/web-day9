package com.example.webday9.repository;

import com.example.webday9.entity.Passport;

public interface PassportRepository {

    public Passport findById(int id);

    public void insert(Passport p);
}
