package com.example.webday9.transform;

import com.example.webday9.dto.InsertStudentDTO;
import com.example.webday9.dto.StudentDTO;
import com.example.webday9.entity.Passport;
import com.example.webday9.entity.Student;

public class StudentTransform {

	public StudentDTO apply(Student s) {
		StudentDTO stu = new StudentDTO();

		stu.setStudentId(s.getId());
		stu.setStudentName(s.getName());

		Passport corePp = s.getPassport();
		stu.setPassportId(corePp.getId());
		stu.setPassportNumber(corePp.getNumber());

		return stu;
	}

	public Student apply(InsertStudentDTO body) {
		Student s = new Student();
		Passport p = new Passport();
		p.setNumber(body.getPassportNumber());
		s.setName(body.getStudentName());
		s.setPassport(p);

		return s;
	}
}
