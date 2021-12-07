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
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue
	@Column(name="subject_id")
	private int subjectId;
	
	@Column(name="subject_desc")
	private String desc; 
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="subject_class_link",
				joinColumns = { @JoinColumn(name="subject_id")},
				inverseJoinColumns = {@JoinColumn(name = "class_id")})
	private List<Classes> laclass;
	
	private int tid;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLaclass() {
		StringBuffer sb = new StringBuffer();
		if(laclass != null) {
			for(Classes lac : laclass) {
				sb.append(lac.getCid()+"|"+lac.getClassName()+",");
			}
		}
		return sb.toString();
	}

	public void setLaclass(List<Classes> laclass) {
		this.laclass = laclass;
	}
		
}
