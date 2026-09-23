package com.code.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	//member variables
	//each member variable will be mapped to a column in the table
	//one of the member variable will be the primary key
	//relationship with course many to many
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="studentid")
	private int studentid;
	@Column(name="first_name",nullable=false,length=30)
	private String firstname;
	@Column(name="last_name",nullable=false,length=30)
	private String lastname;
	@Column(name="email_id",nullable=false,length=30,unique=true)
	private String emailid;
	@Column(name="mobile_no",nullable=false,length=15)
	private String mobileno;
	//create a many to many relationship with course
	@ManyToMany
	//Made a relationship table along with some columns which will be foreign key for this table 
	//inverse column join means another column which to add in relationship table 
	//relationship table( student_course) has only foreign keys
	@JoinTable(name="student_course",joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns =   @JoinColumn(name="course_id"))
	private List<Course> courses;
	//create default constructor
	public Student() {
		this.studentid=0;
		this.firstname=null;
		this.lastname=null;
		this.emailid=null;
		this.mobileno=null;
		this.courses=null;
	}
	//create parameterized constructor
	public Student(String firstname, String lastname, String emailid, String mobileno) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.mobileno = mobileno;
	}
	//getters and setters
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	//add method addToCourse(Course course)
	public void addToCourse(Course course)
	{
		//if courses is null we create object
		if (courses ==null) {
			courses=new ArrayList<Course>();
		}
		//add the object to the list
		courses.add(course);
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid="
				+ emailid + ", mobileno=" + mobileno + ", courses=" + courses + "]";
	}
	
	
	}