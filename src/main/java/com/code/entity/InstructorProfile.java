package com.code.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//class will be mapped to the table in the database
@Entity
@Table(name="instructor_profile")
public class InstructorProfile {
		//members variable
		//each member variable will be mapped to a column in the table
		//one of the member variable will be primary key
		//primary key will be auto-generated
	  @Id //primary key
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="instructor_profile_id")
	  private int instructorProfileId;
	  @Column(name="linkedin_url",length=100)
	  private String linkedinUrl;
	  @Column(name="hobby",length=100)
	  private String hobby;
	  @Column(name="education_qualification",length=100)
	  private String educationqualification;
	  //Create a relationship one to one with instructor class
	  @OneToOne(cascade= CascadeType.ALL)
	  //create cascade type all so that when we delete the instructor profile,
	  //the instructor will also be deleted
	  @JoinColumn(name="instructor_id")
	  private Instructor instructor;
	  // default constructor
	  public InstructorProfile() {
		  this.instructorProfileId=0;
		  this.linkedinUrl=null;
		  this.hobby=null;
		  this.educationqualification=null;
	  }
	  public InstructorProfile(String linkedinUrl, String hobby, String educationqualification, Instructor instructor) {
		super();
		this.linkedinUrl = linkedinUrl;
		this.hobby = hobby;
		this.educationqualification = educationqualification;
		this.instructor = instructor;
	  }
	  //getter and setters
	  public int getInstructorProfileId() {
		return instructorProfileId;
	  }
	  public void setInstructorProfileId(int instructorProfileId) {
		this.instructorProfileId = instructorProfileId;
	  }
	  public String getLinkedinUrl() {
		return linkedinUrl;
	  }
	  public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	  }
	  public String getHobby() {
		return hobby;
	  }
	  public void setHobby(String hobby) {
		this.hobby = hobby;
	  }
	  public String getEducationqualification() {
		return educationqualification;
	  }
	  public void setEducationqualification(String educationqualification) {
		this.educationqualification = educationqualification;
	  }
	  public Instructor getInstructor() {
		return instructor;
	  }
	  public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	  }
	  //toString method
	  @Override
	  public String toString() {
		return "InstructorProfile [instructorProfileId=" + instructorProfileId + ", linkedinUrl=" + linkedinUrl + ", hobby="
				+ hobby + ", educationqualification=" + educationqualification + ", instructor=" + instructor + "]";
	  }
  
}
