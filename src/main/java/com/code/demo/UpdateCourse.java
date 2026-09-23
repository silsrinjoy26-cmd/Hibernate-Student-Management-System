package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;


public class UpdateCourse {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public UpdateCourse(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
		//set the id of the course to update
		int courseupdateid=3;
		//assign the course to instructor id
		int instructorid=1;
		InstructorProfile instructorProfile=session.get(InstructorProfile.class, instructorid);
		//get the course object 
		Course course=session.get(Course.class, courseupdateid);
		//check the id found or not
		if(instructorProfile==null) {
			System.out.println("Instructor with Id "+instructorid+" not found");
			return;
		}
		if(course==null) {
			System.out.println("course with Id "+courseupdateid+" not found");
			return;
		}
		//show the existing object values
		System.out.println(course.toString());
		//update the old value with new value
		course.setDuration("15 hrs");
		course.setFees(15000);
		course.setInstructor(instructorProfile.getInstructor());
		
		//update
		session.merge(course); //merge to update the exiting object
		
		
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Course Updated Sucessfully");
				
	}

}