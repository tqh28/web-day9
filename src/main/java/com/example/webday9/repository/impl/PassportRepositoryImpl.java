package com.example.webday9.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday9.entity.Passport;
import com.example.webday9.repository.PassportRepository;

@Repository
public class PassportRepositoryImpl implements PassportRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public PassportRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Passport findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Passport.class, id);
	}

	@Override
	public void insert(Passport p) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);
	}

}
