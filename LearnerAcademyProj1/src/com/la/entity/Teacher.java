package com.la.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {

	@Id
	@GeneratedValue
	@Column(name="tid")
	private int tid;
	
	@Column(name="skill")
	private String skillset;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	public int getId() {
		return tid;
	}

	public void setId(int id) {
		this.tid = id;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
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
		
}
