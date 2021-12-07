package com.la.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="sid")
	private int sid;
	
	@Column(name="first_name")
	private String first_name;

	@Column(name="second_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_classes_link",
				joinColumns= { @JoinColumn(name="student_id") },
				inverseJoinColumns = { @JoinColumn(name="class_id") })
	private List<Classes> sclasses;

	public int getId() {
		return sid;
	}

	public void setId(int id) {
		this.sid = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Classes> getSclasses() {
		return sclasses;
	}

	public void setSclasses(List<Classes> sclasses) {
		this.sclasses = sclasses;
	}
		
}
