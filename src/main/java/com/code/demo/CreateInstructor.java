package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;


public class CreateInstructor {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public CreateInstructor(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
		//create the instructor object
		//transient 
		Instructor instructor = new Instructor("test1","test1","test1@abc.com");
		//create the instructor profile object
		InstructorProfile instructorProfile = 
				new InstructorProfile("https://www.linkedin.com/in/test1",
						"Reading Book","M-Tech",instructor);
		
		//persist 
		session.persist(instructorProfile); //persist the instructor profile object
		
		//second object
		instructor = new Instructor("test2","test2","test2@abc.com");
		//create the instructor profile object
		 instructorProfile = 
				new InstructorProfile("https://www.linkedin.com/in/test2",
						"Reading Book","M-Tech",instructor);
		
		//persist 
		session.persist(instructorProfile); //persist the instructor profile object
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Instructor and Instructor Profile saved to the "
				+ "database with id"+instructorProfile.getInstructorProfileId());
				
	}

}