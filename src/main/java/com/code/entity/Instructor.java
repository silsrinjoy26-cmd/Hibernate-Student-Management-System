package com.code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//mapped
//class will be mapped to the table in the database
@Entity
@Table(name="instructor")
public class Instructor {
	//members variable
	//each member variable will be mapped to a column in the table
	//one of the member variable will be primary key
	//primary key will be auto-generated
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="fname",nullable=false,length=30)
	private String fname;
	@Column(name="lname",nullable=false,length=30)
	private String lname;
	@Column(name="emailid",nullable=false,length=50,unique=true)
	private String emailid;
	
	//default constructor
	public Instructor() {
		this.id=0;
		this.fname=null;
		this.lname=null;
		this.emailid=null;
	}
	//create parameterized constructor

	public Instructor(String fname, String lname, String emailid) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.emailid = emailid;
	}
	//getter and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	//toString method

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", fname=" + fname + ", lname=" + lname + ", emailid=" + emailid + "]";
	}
	
}
