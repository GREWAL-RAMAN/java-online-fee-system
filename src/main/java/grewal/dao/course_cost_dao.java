package grewal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import grewal.bean.course_cost;



public class course_cost_dao {
	@SuppressWarnings("deprecation")
	public void  addcourse_cost(course_cost my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course_cost.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("course_cost added ->");
			System.out.println(my);
		} finally {
			mySession.close();
			factory.close();
		}
	}
	public course_cost getcourse_cost(int id)
	{
		course_cost my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course_cost.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
		my_s=mySession.get(course_cost.class,id);
	
		System.out.println("course_cost returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
	public course_cost updatecourse_cost(course_cost my_s,int id)
	{
		course_cost my=new course_cost();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course_cost.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(course_cost.class,id);
		System.out.println("course_cost to updated");
		System.out.println(my);
	     my.setCourse_Cost(my_s);
	    mySession.getTransaction().commit(); 
		System.out.println("course_cost updated ->");
		System.out.println(my);
	} finally {
		mySession.close();
		factory.close();
	}				
		return my;
	}
    
	public course_cost deletecourse_cost(int id)
	{

		course_cost my=new course_cost();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course_cost.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(course_cost.class,id);
		System.out.println("course_cost to deleted");
		System.out.println(my);
	    mySession.remove(my);
	    mySession.getTransaction().commit(); 
		System.out.println("course_cost deleted ");
	
	} finally {
		mySession.close();
		factory.close();
	}	
		
		return my;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<course_cost> getAllcourse_cost()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course_cost.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<course_cost> course_costs= mySession.createQuery("from course_cost").getResultList();
           if(!course_costs.isEmpty())
           {
        	   return course_costs;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}
	
	public List<course_cost> getCourseCostByStudentId(int stId) {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(course_cost.class)
	                            .buildSessionFactory();
	    Session session = null;
	    Transaction transaction = null;
	    List<course_cost> courseCosts = null;
	    try {
	        session = factory.getCurrentSession();
	        transaction = session.beginTransaction();
	        String hql = "FROM course_cost cc WHERE cc.st_id = :stId";
	        Query<course_cost> query = session.createQuery(hql, course_cost.class);
	        query.setParameter("stId", stId);
	        courseCosts = query.getResultList();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        factory.close();
	    }
	    return courseCosts;
	}

	public Double getTotalCourseCostByStudentId(int stId) {
	    Session session = null;
	    Double totalCost = 0.0;
	    try {
	        SessionFactory factory = new Configuration()
	                .configure("hibernate.cfg.xml")
	                .addAnnotatedClass(course_cost.class)
	                .buildSessionFactory();
	        session = factory.getCurrentSession();
	        session.beginTransaction();
	        String hql = "SELECT SUM(cc.cost) FROM course_cost cc WHERE cc.st_id = :stId";
	        Query<Double> query = session.createQuery(hql, Double.class);
	        query.setParameter("stId", stId);
	        totalCost = query.getSingleResult();
	        if (totalCost == null) {
	            totalCost = 0.0;
	        }
	        session.getTransaction().commit();
	    } catch (Exception ex) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        ex.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return totalCost;
	}


	
	
}
