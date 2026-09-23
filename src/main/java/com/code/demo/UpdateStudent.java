package com.code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Course;
import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;


public class UpdateStudent {
	//create the member variable of SessionFactory
	private SessionFactory sessionFactory;
	//create the constructor carrying the sessionFactory as parameter
	public UpdateStudent(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		//session object will be created in the method where we will perform the CRUD operations
		Session session = sessionFactory.getCurrentSession(); //returns the current session
		//session with the transaction will be created in the method where we will perform the CRUD operations
		session.beginTransaction(); //begin the transaction
		//set the id of the course to update
		int studentupdateid=1;
		//get the student object
		Student student=session.get(Student.class, studentupdateid);
		//get the all course object 
		//get all the course
		List<Course> courses=session.createQuery("from Course").getResultList();
		//check the id found or not
		if(student==null) {
			System.out.println("Student with Id "+studentupdateid+" not found");
			return;
		}
		
		//show the existing object values
		System.out.println("Name :"+student.getFirstname()+" "+student.getLastname());
		System.out.println("Emailid :"+student.getEmailid());
		System.out.println("Student Course Details");
		for(Course course:student.getCourses()) {
			System.out.println("Title"+course.getTitle());
			System.out.println("Duration"+course.getDuration());
			System.out.println("--------------------------------");
		}
		//remove the course course id 2
		int deletecourseid=2;
		List<Course> studentcourses=student.getCourses();
		for(Course course : studentcourses) {
			if(course.getCourseid()==deletecourseid) {
				studentcourses.remove(course);
				break;
			}
			
		}
		//update
		student.setFirstname("test");
		student.setCourses(studentcourses);
		
		//update
		session.merge(student); //merge to update the exiting object
		
		
		//save the object to the database
		session.getTransaction().commit(); //commit the transaction
		//detached
		session.close(); //close the session
		//message
		System.out.println("Student Updated Sucessfully");
				
	}

}