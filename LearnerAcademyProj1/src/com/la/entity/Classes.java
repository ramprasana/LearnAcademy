package com.la.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="classes")
public class Classes {
	
	@Id
	@GeneratedValue
	@Column(name="class_id")
	private int cid;
	
	@Column(name="class_name")
	private String className;
	
	@Column(name="start_date")
	private Date sDate;
	
	@Column(name="end_date")
	private Date eDate;
	
	@ManyToMany(mappedBy="laclass", cascade=CascadeType.ALL)
	private List<Subject> subject;
		
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="sclasses", cascade=CascadeType.ALL)
	private List<Student> student;

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
}
