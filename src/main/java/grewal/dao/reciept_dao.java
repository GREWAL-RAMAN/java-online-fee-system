package grewal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import grewal.bean.reciept;

public class reciept_dao {
	@SuppressWarnings("deprecation")
	public void  addreciept(reciept my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(reciept.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("reciept added ->");
			System.out.println(my);
		} finally {
			mySession.close();
			factory.close();
		}
	}
	public reciept getreciept(reciept my_s,int id)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(reciept.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
		my_s=mySession.get(reciept.class,id);
	
		System.out.println("reciept returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
	public reciept updatereciept(reciept my_s,int id)
	{
		reciept my=new reciept();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(reciept.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(reciept.class,id);
		System.out.println("reciept to updated");
		System.out.println(my);
	     my.setreciept(my_s);
	    mySession.getTransaction().commit(); 
		System.out.println("reciept updated ->");
		System.out.println(my);
	} finally {
		mySession.close();
		factory.close();
	}				
		return my;
	}
    
	public reciept deletereciept(int id)
	{

		reciept my=new reciept();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(reciept.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(reciept.class,id);
		System.out.println("reciept to deleted");
		System.out.println(my);
	    mySession.remove(my);
	    mySession.getTransaction().commit(); 
		System.out.println("reciept deleted ");
	
	} finally {
		mySession.close();
		factory.close();
	}	
		
		return my;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<reciept> getAllreciept()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(reciept.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<reciept> reciepts= mySession.createQuery("from reciept").getResultList();
           if(!reciepts.isEmpty())
           {
        	   return reciepts;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}


}
