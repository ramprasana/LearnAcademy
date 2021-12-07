package com.la.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.la.entity.Classes;
import com.la.entity.Student;
import com.la.entity.Subject;
import com.la.entity.Teacher;

public class HibernateUtil {
	//SessionFactory sessionFactory = null; 
	
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")														
														.addAnnotatedClass(Classes.class)
														.addAnnotatedClass(Subject.class)
														.addAnnotatedClass(Student.class)
														.addAnnotatedClass(Teacher.class).buildSessionFactory();
		return sessionFactory;
	}
}
