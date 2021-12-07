package com.la.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.la.entity.Teacher;
import com.la.util.HibernateUtil;

public class TeacherDao {
	
	/* Save Teacher object */
	public void saveTeacher(Teacher teacher) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			//Start the transaction 
			transaction = session.beginTransaction();
			// save the Subject 
			session.save(teacher);
			// commit transaction 
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}		
	}
	
	/* List Teacher object */
	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeacher() {
		Transaction transaction = null;
		List<Teacher> listOfTeacher = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			//start the transaction
			transaction = session.beginTransaction();
			// get a Subject object
			listOfTeacher = session.createQuery("from Teacher").getResultList();
			//commit transaction
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return listOfTeacher;
	}
	
	//Get Subject by id
	public Teacher getTeacherId(int techId) {
		Transaction transaction = null;
		Teacher tech = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction 
			transaction = session.beginTransaction();
			//get an class object
			tech= session.get(Teacher.class, techId);
			// commit transaction
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return tech;
	}	
}
