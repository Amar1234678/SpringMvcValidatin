package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stu_data1")
public class Student {
     public Student() {
	System.out.println("student obj");	// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	
	@Column
	private String collegeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	@Column
    private String email;
	@Column
	private long mobileNo;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", collegeName=" + collegeName + ", email=" + email
				+ ", mobileNo=" + mobileNo + "]";
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setPass(String collegeName) {
		this.collegeName = collegeName;
	}
}
