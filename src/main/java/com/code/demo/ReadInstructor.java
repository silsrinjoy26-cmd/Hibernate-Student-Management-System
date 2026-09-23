package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.InstructorProfile;

public class ReadInstructor {

	private SessionFactory sessionFactory;
	public ReadInstructor(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//create the session object 
		Session session=sessionFactory.getCurrentSession();
		//open the transaction
		session.beginTransaction();
		//build query to get all the object
	List<InstructorProfile> instructorProfiles=	
			session.createQuery("from InstructorProfile").getResultList();
	//read one by one object from the list
	for(InstructorProfile instructorProfile:instructorProfiles) {
		System.out.println(instructorProfile.toString());
		
	}
	
	}
}