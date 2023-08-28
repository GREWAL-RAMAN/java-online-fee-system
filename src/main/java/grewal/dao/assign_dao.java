package grewal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import grewal.bean.assign;

public class assign_dao {
	@SuppressWarnings("deprecation")
	public void  addassign(assign my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(assign.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
		
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("assign added ->");
			System.out.println(my);
		} finally {
			mySession.close();
			factory.close();
		}
	}
	public assign getassign(int id)
	{
		assign my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(assign.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
	
		mySession.beginTransaction();
		 my_s=mySession.get(assign.class,id);
	
		System.out.println("assign returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
	public assign updateassign(assign my_s,int id)
	{
		assign my=new assign();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(assign.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(assign.class,id);
		System.out.println("assign to updated");
		System.out.println(my);
	     my.setassign(my_s);
	    mySession.getTransaction().commit(); 
		System.out.println("assign updated ->");
		System.out.println(my);
	} finally {
		mySession.close();
		factory.close();
	}				
		return my;
	}
    
	public assign deleteassign(int id)
	{

		assign my=new assign();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(assign.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(assign.class,id);
		System.out.println("assign to deleted");
		System.out.println(my);
	    mySession.remove(my);
	    mySession.getTransaction().commit(); 
		System.out.println("assign deleted ");
	
	} finally {
		mySession.close();
		factory.close();
	}	
		
		return my;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<assign> getAllassign()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(assign.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<assign> assigns= mySession.createQuery("from assign").getResultList();
           if(!assigns.isEmpty())
           {
        	   return assigns;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}

}
