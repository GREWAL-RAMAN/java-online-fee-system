package grewal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import grewal.bean.st_course;
import grewal.bean.accountantBean;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class accountantDao {
	@SuppressWarnings("deprecation")
	public void  addaccountantBean(accountantBean my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(accountantBean.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("accountantBean added ->");
			System.out.println(my);
			
		} finally {
			mySession.close();
			factory.close();
		}
	}
	public boolean validateAccountant(String email, String password) {
	    SessionFactory sessionFactory = null;
	    Session session = null;
	    try {
	        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(accountantBean.class).buildSessionFactory();
	        session = sessionFactory.getCurrentSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<accountantBean> criteriaQuery = builder.createQuery(accountantBean.class);
	        Root<accountantBean> root = criteriaQuery.from(accountantBean.class);
	        criteriaQuery.select(root).where(builder.equal(root.get("email"), email), builder.equal(root.get("password"), password));
	        Query<accountantBean> query = session.createQuery(criteriaQuery);
	        List<accountantBean> results = query.getResultList();

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

	public accountantBean getaccountantBean(int id)
	{
		accountantBean my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(accountantBean.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
		my_s=mySession.get(accountantBean.class,id);
	
		System.out.println("accountantBean returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
	public accountantBean updateaccountantBean(accountantBean my_s,int id)
	{
		accountantBean my=new accountantBean();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(accountantBean.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(accountantBean.class,id);
		System.out.println("accountantBean to updated");
		System.out.println(my);
	     my.setaccountantBean(my_s);
	    mySession.getTransaction().commit(); 
		System.out.println("accountantBean updated ->");
		System.out.println(my);
	} finally {
		mySession.close();
		factory.close();
	}				
		return my;
	}
    
	public accountantBean deleteaccountantBean(int id)
	{

		accountantBean my=new accountantBean();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(accountantBean.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(accountantBean.class,id);
		System.out.println("accountantBean to deleted");
		System.out.println(my);
	    mySession.remove(my);
	    mySession.getTransaction().commit(); 
		System.out.println("accountantBean deleted ");
	
	} finally {
		mySession.close();
		factory.close();
	}	
		
		return my;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<accountantBean> getAllaccountantBean()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(accountantBean.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<accountantBean> accountantBeans= mySession.createQuery("from accountantbean").getResultList();
           if(!accountantBeans.isEmpty())
           {
        	   return accountantBeans;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}
//	public List<accountantBean> getaccountantBeansNotInCourse() {
//		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(accountantBean.class)
//                .buildSessionFactory();
//	    Session session = factory.getCurrentSession();
//	    session.beginTransaction();
//	    String hql = "FROM accountantBean s WHERE s.id NOT IN (SELECT c.st_id FROM st_course c)";
//	    Query query = session.createQuery(hql, accountantBean.class);
//	    @SuppressWarnings("unchecked")
//		List<accountantBean> accountantBeans = query.getResultList();
//		session.close();
//		factory.close();
//	    return accountantBeans;
//	}
//
	
	public List<accountantBean>  getaccountantBeansNotInCourse() {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                 .addAnnotatedClass(accountantBean.class)
                 .addAnnotatedClass(st_course.class)
                 .buildSessionFactory();
		Session session = factory.getCurrentSession();	
		session.beginTransaction();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<accountantBean> criteria = builder.createQuery(accountantBean.class);
	    Root<accountantBean> rootTable1 = criteria.from(accountantBean.class);

	    // Subquery to get IDs in Table2
	    Subquery<Integer> subquery = criteria.subquery(Integer.class);
	    Root<st_course> rootTable2 = subquery.from(st_course.class);
	    subquery.select(rootTable2.get("st_id").as(Integer.class));
	    
	    Predicate predicate = builder.equal(rootTable1.get("id"), rootTable2.get("st_id"));
	    subquery.where(predicate);

	    // Main query to get data from Table1 that's not in Table2
	    criteria.select(rootTable1);
	    predicate = builder.not(rootTable1.get("id").in(subquery));
	    criteria.where(predicate);

	    return session.createQuery(criteria).getResultList();
	}
}
