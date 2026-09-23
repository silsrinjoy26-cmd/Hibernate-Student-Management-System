package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;

public class ReadStudent {

	private SessionFactory sessionFactory;
	public ReadStudent(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		//create the session object 
		Session session=sessionFactory.getCurrentSession();
		//open the transaction
		session.beginTransaction();
		//build query to get all the object
		List<Student> students=	session.createQuery("from Student").getResultList();
		System.out.println("Student Details");
		//read one by one object from the list
		for(Student student:students) {
			System.out.println("Name :"+student.getFirstname()+" "+student.getLastname());
			System.out.println("Emailid :"+student.getEmailid());
			System.out.println("Student Course Details");
			for(Course course:student.getCourses()) {
				System.out.println("Title"+course.getTitle());
				System.out.println("Duration"+course.getDuration());
				System.out.println("--------------------------------");
			}
			
		}
	
	}
}