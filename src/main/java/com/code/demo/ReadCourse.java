package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;

public class ReadCourse {

	private SessionFactory sessionFactory;
	public ReadCourse(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//create the session object 
		Session session=sessionFactory.getCurrentSession();
		//open the transaction
		session.beginTransaction();
		//build query to get all the object
	List<Course> courses=	
			session.createQuery("from Course").getResultList();
	//read one by one object from the list
	for(Course course:courses) {
		System.out.println(course.toString());
		
	}
	
	}
}