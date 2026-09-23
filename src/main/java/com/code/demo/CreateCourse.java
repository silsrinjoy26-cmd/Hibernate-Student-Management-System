package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;


public class CreateCourse {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public CreateCourse(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
		//set instructor id to assign the course
		int instructorid=1;
		Instructor instructor = session.get(Instructor.class, instructorid);
		if(instructor==null)
		{
			System.out.println("Instructor with Id "+instructorid+" not found");
			return;
		}
		//create the object of the course
		Course course=new Course("Java", "15 hrs", 5000, instructor);
		
		//persist /save the object
		session.persist(course); //object will be inserted into the table
		
		//second object
			course=new Course("Advance Java", "25 hrs", 10000, instructor);
		
		//persist /save the object
		session.persist(course); //object will be inserted into the table
		//third object
		course=new Course("Spring Boot", "10 hrs", 10000, instructor);
	
		//persist /save the object
		session.persist(course); //object will be inserted into the table
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Course is created sucessfully");
				
	}

}