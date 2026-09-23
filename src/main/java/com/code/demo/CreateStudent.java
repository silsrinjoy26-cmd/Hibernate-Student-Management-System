package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;


public class CreateStudent {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public CreateStudent(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
	
		//get all the course
		List<Course> courses=session.createQuery("from Course").getResultList();
		//create the object of the student
		Student student=new Student("Abcd","Xyz", "abc@abc.com", "1234567890");
		//assign to course to student
		Course course=courses.stream().filter(c->c.getTitle().equalsIgnoreCase("advance java"))
													.findAny().orElse(null);
		if(course!=null)
		{
			//add the course to student
			student.addToCourse(course);
		}
		course=courses.stream().filter(c->c.getCourseid()==3)
				.findAny().orElse(null);
			if(course!=null)
				{
					//add the course to student
					student.addToCourse(course);
				}
		//persist /save the object
		session.persist(student); //object will be inserted into the table
		
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Student is created sucessfully");
				
	}

}