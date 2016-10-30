package com.journaldev.spring.service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.Employee;

import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void register(Employee emp){
		// Acquire session
		Session session = sessionFactory.getCurrentSession();
		// Save employee, saving behavior get done in a transactional manner
		session.save(emp);		
	}

	@Transactional
	public List<Employee> getEmployes() {
		// Acquire session
		Session session = sessionFactory.getCurrentSession();
		//Getting of employes from database
        SQLQuery query = session.createSQLQuery("Select * from employee");
        return (List<Employee>) query.list();
	}
}
