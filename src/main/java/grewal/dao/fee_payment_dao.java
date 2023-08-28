package grewal.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import grewal.bean.fee_cost;
import grewal.bean.fee_payment;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class fee_payment_dao {
	@SuppressWarnings("deprecation")
	public void addFeeCoursePayment(fee_payment payment) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(fee_payment.class)
                .addAnnotatedClass(fee_cost.class)
               
                .buildSessionFactory();
	    Session session = null;
	    Transaction tx = null;

	    try {
	        session = factory.getCurrentSession();
	        tx = session.beginTransaction();

	        // Insert fee_payment into the database
	        session.save(payment);

	        // Update fee_cost payed field where type=1 and cost_id=p_id
	        Query<?> query = session.createQuery("UPDATE fee_cost SET payed = payed + :amount WHERE co_id = :coId");
	        query.setParameter("amount", payment.getAmount());
	        query.setParameter("coId", payment.getP_id());
	        query.executeUpdate();

	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	       }
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<fee_payment> getAllFee_payment()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_payment.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<fee_payment> courses= mySession.createQuery("from fee_payment").getResultList();
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
	public List<fee_payment> getFeePaymentsByPId(int pId) {
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(fee_payment.class)
                .buildSessionFactory();
	    Session session = null;
	    List<fee_payment> feePayments = null;
	    try {
	        session = factory.getCurrentSession();
	        Transaction transaction = session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<fee_payment> query = builder.createQuery(fee_payment.class);
	        Root<fee_payment> root = query.from(fee_payment.class);
	        query.select(root).where(builder.equal(root.get("p_id"), pId));
	        feePayments = session.createQuery(query).getResultList();
	        transaction.commit();
	    } catch (Exception e) {
	        if (session != null && session.getTransaction().isActive()) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        factory.close();
	    }
	    return feePayments;
	}
	public fee_payment getMaxIdRecord() {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
	            .addAnnotatedClass(fee_payment.class)
	            .buildSessionFactory();
	    Session session = null;
	    fee_payment result = null;
	    try {
	        session = factory.getCurrentSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<fee_payment> query = builder.createQuery(fee_payment.class);
	        Root<fee_payment> root = query.from(fee_payment.class);
	        query.select(root);
	        query.orderBy(builder.desc(root.get("id")));
	        Query<fee_payment> q = session.createQuery(query);
	        q.setMaxResults(1);
	        result = q.getSingleResult();
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
	        factory.close();
	    }
	    return result;
	}

}
