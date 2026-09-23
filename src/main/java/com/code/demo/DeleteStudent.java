package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Student;


public class DeleteStudent {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public DeleteStudent(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
		//set the id of the student to delete
		int deletedid=1;
		//get the object with the id 1
		Student student=session.get(Student.class, deletedid);
		//check the id found or not
		if(student==null) {
			System.out.println("Student with Id "+deletedid+" not found");
			return;
		}
		//show the existing object values
		System.out.println(student.toString());
		
		
		//remove the object
		session.remove(student); //delete exiting object
		
		
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Student with id "+deletedid+" is deleted sucessfully");
				
	}

}