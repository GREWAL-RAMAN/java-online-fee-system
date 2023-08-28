package grewal.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import grewal.bean.fee_cost;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class fee_cost_dao {
	@SuppressWarnings("deprecation")
	public void  addfee_cost(fee_cost my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_cost.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("fee_cost added ->");
			System.out.println(my);
		} finally {
			mySession.close();
			factory.close();
		}
	}
	@SuppressWarnings("deprecation")
	public void updateFeeCostStatus() {
	    SessionFactory factory = null;
	    Session session = null;
	    try {
	        factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_cost.class)
	                .buildSessionFactory();
	        session = factory.getCurrentSession();
	        session.beginTransaction();
	        List<fee_cost> feeCostList = session.createQuery("FROM fee_cost", fee_cost.class).getResultList();
	        for (fee_cost fc : feeCostList) {
	            if (fc.getCost() == fc.getPayed()) {
	                fc.setStatus("complete");
	            } else {
	                fc.setStatus("pending");
	            }
	            session.update(fc);
	        }
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        if (factory != null) {
	            factory.close();
	        }
	    }
	}

	public List<fee_cost> getPendingFeeCosts(int st_id) {
	    SessionFactory factory = null;
	    Session session = null;
	    List<fee_cost> results = null;
	    try {
	        factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_cost.class)
	                .buildSessionFactory();
	        session = factory.getCurrentSession();
	         session.beginTransaction();
	         Query<fee_cost> query = session.createQuery("SELECT DISTINCT fc FROM fee_cost fc WHERE fc.st_id = :st_id AND fc.status = 'pending'", fee_cost.class);
	        query.setParameter("st_id", st_id);
	        results = query.list();
	       session.getTransaction().commit();
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        if (factory != null) {
	            factory.close();
	        }
	    }
	    return results;
	}

	public List<fee_cost> getFeeCostByStatus(String status) {
	    SessionFactory factory = null;
	    Session session = null;
	    List<fee_cost> results = null;

	    try {
	        factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_cost.class)
	                .buildSessionFactory();
	        session = factory.getCurrentSession();
	        session.beginTransaction();

	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<fee_cost> query = builder.createQuery(fee_cost.class);
	        Root<fee_cost> root = query.from(fee_cost.class);
	        query.select(root).where(builder.equal(root.get("status"), status));
	        Query<fee_cost> q = session.createQuery(query);
	        results = q.getResultList();

	        session.getTransaction().commit();
	    } catch (HibernateException e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        if (factory != null) {
	            factory.close();
	        }
	    }

	    return results;
	}


	public fee_cost getfee_cost(int id)
	{
		fee_cost my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_cost.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
		my_s=mySession.get(fee_cost.class,id);
	
		System.out.println("fee_cost returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
		
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<fee_cost> getAllfee_cost()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_cost.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<fee_cost> fee_costs= mySession.createQuery("from fee_cost").getResultList();
           if(!fee_costs.isEmpty())
           {
        	   return fee_costs;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}
	public fee_cost getFeeCostByCourseId(int co_id) {
	    SessionFactory factory = new Configuration()
	        .configure("hibernate.cfg.xml")
	        .addAnnotatedClass(fee_cost.class)
	        .buildSessionFactory();
	    Session session = factory.getCurrentSession();
	    Transaction tx = null;
	    fee_cost feeCost = null;

	    try {
	        tx = session.beginTransaction();
	        feeCost = session.get(fee_cost.class, co_id);
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

	    return feeCost;
	}

	

}
