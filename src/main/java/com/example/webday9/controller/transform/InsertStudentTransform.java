package com.example.webday9.controller.transform;

import com.example.webday9.controller.model.InsertStudentRequest;
import com.example.webday9.entity.Passport;
import com.example.webday9.entity.Student;

public class InsertStudentTransform {

    public Student apply(InsertStudentRequest body) {
        Student s = new Student();
        Passport p = new Passport();
        p.setNumber(body.getPassportNumber());
        s.setName(body.getStudentName());
        s.setPassport(p);

        return s;
    }
}
