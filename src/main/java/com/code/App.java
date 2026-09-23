package com.code;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.demo.*;
import com.code.entity.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	//create configuration object 
  SessionFactory sessionFactory=  	new Configuration().configure("hibernate.cfg.xml")
		  							.addAnnotatedClass(Instructor.class)
		  							.addAnnotatedClass(InstructorProfile.class)
		  							.addAnnotatedClass(Student.class)
		  							.addAnnotatedClass(Course.class)
		  							.buildSessionFactory();
  //create the object of CreateInstructor class and pass the sessionFactory object to it
//  new CreateInstructor(sessionFactory);
//  new ReadInstructor(sessionFactory);
//  new UpdateInstructor(sessionFactory);
//  new DeleteInstructor(sessionFactory);
//  new CreateCourse(sessionFactory);
//  new ReadCourse(sessionFactory);
//  new UpdateCourse(sessionFactory);
//  new DeleteCourse(sessionFactory);
//  new CreateStudent(sessionFactory);
//  new ReadStudent(sessionFactory);
//  new UpdateStudent(sessionFactory);
//  new DeleteStudent(sessionFactory);  
    }	
}