package com.la.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.la.entity.Classes;
import com.la.entity.Subject;
import com.la.util.HibernateUtil;

public class SubjectDao {
	
	/* Save the subject */
	public void saveSubject(Subject sub) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			//Start the transaction 
			transaction = session.beginTransaction();
			// save the Subject 
			session.save(sub);
			// commit transaction 
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
	}
	
	/* Get the subject list */
	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubject() {
		Transaction transaction = null;
		List<Subject> listOfSubject = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			//start the transaction
			transaction = session.beginTransaction();
			// get a Subject object
			listOfSubject = session.createQuery("from Subject").getResultList();
			//commit transaction
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return listOfSubject;
	}
	
	//Get Subject by id
	public Subject getSubjectId(int subid) {
		Transaction transaction = null;
		Subject subj = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction 
			transaction = session.beginTransaction();
			//get an class object
			subj= session.get(Subject.class, subid);
			// commit transaction
			transaction.commit();
		} catch(Exception ex) {
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return subj;
	}	
	
	/* Update */	
	public void updateSubject(Subject subject) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction 
			transaction = session.beginTransaction();
			// save the classes
			//session.update(existingClass);
			System.out.println("Subject Class assignment : " + subject.getLaclass());
			session.update(subject);
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
