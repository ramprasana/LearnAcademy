package com.la.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.la.entity.Student;
import com.la.entity.Subject;
import com.la.util.HibernateUtil;

public class StudentDao {
	// Save Student
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			//Start the transaction 
			transaction = session.beginTransaction();
			// save the Subject 
			session.save(student);
			// commit transaction 
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}		
	}
	// List Student
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		Transaction transaction = null;
		List<Student> listOfStudent = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			//start the transaction
			transaction = session.beginTransaction();
			// get a Subject object
			listOfStudent = session.createQuery("from Student").getResultList();
			//commit transaction
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return listOfStudent;		
	}
	
	//Get Subject by id
	public Student getStudentId(int studid) {
		Transaction transaction = null;
		Student stud = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction 
			transaction = session.beginTransaction();
			//get an class object
			stud = session.get(Student.class, studid);
			// commit transaction
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return stud;
	}	
	
	/* Update */	
	public void updateStudent(Student stud) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction 
			transaction = session.beginTransaction();
			// save the classes
			//session.update(existingClass);
			//System.out.println("Student Class assignment : " + stud.getLaclass());
			session.update(stud);
			//commit transaction.
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if((session != null) && (session.isOpen())) {
				session.close();
			}
		}
	}	
	
}
