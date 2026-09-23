package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;


public class DeleteInstructor {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public DeleteInstructor(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
		//set the id of the instructor to delete
		int deletedid=2;
		//get the object with the id 3
		InstructorProfile instructorProfile=session.get(InstructorProfile.class, deletedid);
		//check the id found or not
		if(instructorProfile==null) {
			System.out.println("Instructor with Id "+deletedid+" not found");
			return;
		}
		//show the existing object values
		System.out.println(instructorProfile.toString());
		
		
		//remove the object
		session.remove(instructorProfile); //delete exiting object
		
		
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Instructor Profile with is "+deletedid+" is deleted sucessfully");
				
	}

}