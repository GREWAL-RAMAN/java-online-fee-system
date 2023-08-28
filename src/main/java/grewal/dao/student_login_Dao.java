package grewal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import grewal.bean.student_login;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class student_login_Dao {

	@SuppressWarnings("deprecation")
	public void  addstudent_login(student_login my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student_login.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("student_login added ->");
			System.out.println(my);
		} finally {
			mySession.close();
			factory.close();
		}
	}
	public student_login getstudent_login(int id)
	{
		student_login my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student_login.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
		my_s=mySession.get(student_login.class,id);
	
		System.out.println("student_login returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
	public boolean validateAccountant(String email, String password) {
	    SessionFactory sessionFactory = null;
	    Session session = null;
	    try {
	        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student_login.class).buildSessionFactory();
	        session = sessionFactory.getCurrentSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<student_login> criteriaQuery = builder.createQuery(student_login.class);
	        Root<student_login> root = criteriaQuery.from(student_login.class);
	        criteriaQuery.select(root).where(builder.equal(root.get("username"), email), builder.equal(root.get("password"), password));
	        Query<student_login> query = session.createQuery(criteriaQuery);
	        List<student_login> results = query.getResultList();

	        session.getTransaction().commit();
	        return (results.size() == 1);
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        return false;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        if (sessionFactory != null) {
	            sessionFactory.close();
	        }
	    }
	}
	public student_login updatestudent_login(student_login my_s,int id)
	{
		student_login my=new student_login();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student_login.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(student_login.class,id);
		System.out.println("student_login to updated");
		System.out.println(my);
	     my.setstudent_login(my_s);
	    mySession.getTransaction().commit(); 
		System.out.println("student_login updated ->");
		System.out.println(my);
	} finally {
		mySession.close();
		factory.close();
	}				
		return my;
	}
    
	public student_login deletestudent_login(int id)
	{

		student_login my=new student_login();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student_login.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(student_login.class,id);
		System.out.println("student_login to deleted");
		System.out.println(my);
	    mySession.remove(my);
	    mySession.getTransaction().commit(); 
		System.out.println("student_login deleted ");
	
	} finally {
		mySession.close();
		factory.close();
	}	
		
		return my;
	}
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public student_login getStudentByUsername(String username) {
	    SessionFactory factory = new Configuration()
	            .configure("hibernate.cfg.xml")
	            .addAnnotatedClass(student_login.class)
	            .buildSessionFactory();
	    Session session = null;
	    Transaction tx = null;
	    student_login student = null;

	    try {
	        session = factory.getCurrentSession();
	        tx = session.beginTransaction();

	        Query query = session.createQuery("from student_login where username=:username");
	        query.setParameter("username", username);
	        student = (student_login) query.uniqueResult();

	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        factory.close();
	    }

	    return student;
	}

}
