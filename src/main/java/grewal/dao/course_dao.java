package grewal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import grewal.bean.course;

public class course_dao {
	@SuppressWarnings("deprecation")
	public void  addCourse(course my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("course added ->");
			System.out.println(my);
		} finally {
			mySession.close();
			factory.close();
		}
	}
	public course getcourse(int id)
	{
		course my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
		my_s=mySession.get(course.class,id);
	
		System.out.println("course returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
	public course updatecourse(course my_s,int id)
	{
		course my=new course();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(course.class,id);
		System.out.println("course to updated");
		System.out.println(my);
	     my.setCourse(my_s);
	    mySession.getTransaction().commit(); 
		System.out.println("course updated ->");
		System.out.println(my);
	} finally {
		mySession.close();
		factory.close();
	}				
		return my;
	}
    
	public course deletecourse(int id)
	{

		course my=new course();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(course.class,id);
		System.out.println("course to deleted");
		System.out.println(my);
	    mySession.remove(my);
	    mySession.getTransaction().commit(); 
		System.out.println("course deleted ");
	
	} finally {
		mySession.close();
		factory.close();
	}	
		
		return my;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<course> getAllcourse()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<course> courses= mySession.createQuery("from course").getResultList();
           if(!courses.isEmpty())
           {
        	   return courses;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}

}
