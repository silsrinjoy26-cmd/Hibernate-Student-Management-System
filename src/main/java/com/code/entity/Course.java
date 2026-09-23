package com.code.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Many instructor to one course and one course to one instructor

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//AutoIncrement
	@Column(name="courseid")
	private int courseid;
	
	@Column(name="title", nullable=false, unique= true, length=30)
	private String title;
	
	@Column(name="duration", nullable=false, length=30)
	private String duration;
	
	@Column(name="fees", nullable=false)
	private double fees;
	
	//relationship with instructor many to one
	// one instructor can teach many courses but one course has one instructor
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	public Course() {
		this.courseid=0;
		this.duration=null;
		this.fees=0;
		this.instructor=null;
		this.title=null;

	}

	public Course(String title, String duration, double fees, Instructor instructor) {
		super();
		this.title = title;
		this.duration = duration;
		this.fees = fees;
		this.instructor = instructor;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", title=" + title + ", duration=" + duration + ", fees=" + fees
				+ ", instructor=" + instructor + "]";
	}
}