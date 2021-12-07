package com.la.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.la.entity.Classes;
import com.la.entity.Student;
import com.la.entity.Subject;
import com.la.util.HibernateUtil;

public class ClassesDao {

	/* Save Classes */
	public void saveClasses(Classes cal) {
		Transaction trans = null;
		Session session = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			trans = session.beginTransaction();
			//save the classes
			session.save(cal);
			trans.commit();
		} catch(Exception ex) {
			if(trans != null) {
				trans.rollback();
			}
			ex.printStackTrace();			
		} finally {
			if((session != null) && (session.isOpen())) {
				session.close();
			}			
		}
	}
	
	//Get the classes
	@SuppressWarnings("unchecked")
	public List<Classes> getAllClasses() {
		List<Classes> listOfClasses = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			listOfClasses = session.createQuery("from Classes").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if((session != null) && (session.isOpen())) {
				session.close();
			}
		}
		return listOfClasses;
	}

	//Get a single class
	public Classes getClass(String className) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("SELECT c.class_id, c.class_name, c.start_date, c.end_date FROM Classes c "
				+ "WHERE c.class_name=:cname");
		query.setParameter("cname", className);
		Classes c = (Classes) query.getSingleResult();
		return c;
	}
	
	//Get Class by id
	public Classes getClassId(int cid) {
		Transaction transaction = null;
		Classes classes = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction 
			transaction = session.beginTransaction();
			//get an class object
			classes = session.get(Classes.class, cid);
			// commit transaction
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
		return classes;
	}
	
	/* Update */	
	public void updateClasses(Classes existingClass) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction 
			transaction = session.beginTransaction();
			// save the classes
			//session.update(existingClass);
			List<Student> listStudent = existingClass.getStudent();
			for(Student stud: listStudent) {
				System.out.println(stud.getId() + " - " + stud.getEmail());
			}
			session.update(existingClass);
			//session.merge(existingClass);
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
