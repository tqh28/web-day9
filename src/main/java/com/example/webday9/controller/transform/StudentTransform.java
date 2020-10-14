package com.example.webday9.controller.transform;

import com.example.webday9.controller.model.StudentResponse;
import com.example.webday9.entity.Passport;
import com.example.webday9.entity.Student;

public class StudentTransform {

	public StudentResponse apply(Student s) {
		StudentResponse stu = new StudentResponse();

		stu.setStudentId(s.getId());
		stu.setStudentName(s.getName());

		Passport corePp = s.getPassport();
		stu.setPassportId(corePp.getId());
		stu.setPassportNumber(corePp.getNumber());

		return stu;
	}
}
