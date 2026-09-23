package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;


public class DeleteCourse {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public DeleteCourse(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
		//set the id of the course to delete
		int deletedid=1;
		//get the object with the id 1
		Course course=session.get(Course.class, deletedid);
		//check the id found or not
		if(course==null) {
			System.out.println("Course with Id "+deletedid+" not found");
			return;
		}
		//show the existing object values
		System.out.println(course.toString());
		
		
		//remove the object
		session.remove(course); //delete exiting object
		
		
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Course with is "+deletedid+" is deleted sucessfully");
				
	}

}