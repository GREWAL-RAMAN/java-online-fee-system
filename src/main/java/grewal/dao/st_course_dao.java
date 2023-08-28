package grewal.dao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import grewal.bean.course;
import grewal.bean.st_course;
import grewal.bean.student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class st_course_dao {
	@SuppressWarnings("deprecation")
	public double addStCourseAndCalculateCost(st_course myCourse) {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                 .addAnnotatedClass(student.class)
                 .addAnnotatedClass(st_course.class)
                 .addAnnotatedClass(course.class)
                 .buildSessionFactory();
	    double totalCost = 0.0;
	    Session session = null;
	    Transaction tx = null;
	    try {
	        session =factory.getCurrentSession();	
	        tx = session.beginTransaction();
	        
	        // Add st_course to the database
	        session.save(myCourse);

	        // Get cost_perDay from course table by co_id
	        course dbCourse = session.get(course.class, myCourse.getCo_id());
	        double costPerDay = Double.parseDouble(dbCourse.getCost_perDay());
	        
	        // Calculate the number of working days
	        LocalDate startDate = LocalDate.parse(myCourse.getStart_date());
	        LocalDate endDate = LocalDate.parse(myCourse.getEnd_date());
	        int workingDays = 0;
	        while (!startDate.isAfter(endDate)) {
	            if (startDate.getDayOfWeek() != DayOfWeek.SATURDAY && startDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
	                workingDays++;
	            }
	            startDate = startDate.plusDays(1);
	        }
	        System.out.println(workingDays);
	        
	        // Calculate the total cost
	        totalCost = costPerDay * workingDays;
	        
	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	       factory.close();
	    }
	    return totalCost;
	}
	public st_course getLastAddedRecord() {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                 .addAnnotatedClass(st_course.class)
                 .buildSessionFactory();
	    Session session = null;
	    st_course result = null;
	    try {
	        session = factory.getCurrentSession();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<st_course> query = builder.createQuery(st_course.class);
	        Root<st_course> root = query.from(st_course.class);
	        query.select(root);
	        query.orderBy(builder.desc(root.get("id")));
	        Query<st_course> q = session.createQuery(query);
	        q.setMaxResults(1);
	        result = q.getSingleResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	        factory.close();
	    }
	    return result;
	}
	public st_course GetLastAddedRecord() {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                 .addAnnotatedClass(st_course.class)
                 .buildSessionFactory();
	    Session session = null;
	    st_course result = null;
	    try {
	        session = factory.getCurrentSession();
	        String sql = "SELECT * FROM st_course ORDER BY id DESC LIMIT 1";
	        NativeQuery<st_course> query = session.createNativeQuery(sql, st_course.class);
	        result = query.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return result;
	}

	public st_course getMaxIdRecord() {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
	            .addAnnotatedClass(st_course.class)
	            .buildSessionFactory();
	    Session session = null;
	    st_course result = null;
	    try {
	        session = factory.getCurrentSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<st_course> query = builder.createQuery(st_course.class);
	        Root<st_course> root = query.from(st_course.class);
	        query.select(root);
	        query.orderBy(builder.desc(root.get("id")));
	        Query<st_course> q = session.createQuery(query);
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



	public st_course getst_course(int id)
	{
		st_course my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(st_course.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
	
		mySession.beginTransaction();
		 my_s=mySession.get(st_course.class,id);
	
		System.out.println("st_course returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
		@SuppressWarnings({ "unchecked", "deprecation" })
	public List<st_course> getAllst_course()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(st_course.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<st_course> st_courses= mySession.createQuery("from st_course").getResultList();
           if(!st_courses.isEmpty())
           {
        	   return st_courses;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<course> getUnassignedCourses(int studentId) {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                 .addAnnotatedClass(student.class)
                 .addAnnotatedClass(st_course.class)
                 .addAnnotatedClass(course.class)
                 .buildSessionFactory();
		Session session = factory.getCurrentSession();	
	    session.beginTransaction();
	    
	    @SuppressWarnings("deprecation")
		List<course> unassignedCourses = session.createQuery(
	            "SELECT c FROM course c WHERE c.id NOT IN "
	            + "(SELECT sc.co_id FROM st_course sc WHERE sc.st_id = :studentId)"
	    ).setParameter("studentId", studentId).getResultList();
	    
	    session.getTransaction().commit();
	    return unassignedCourses;
	}

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public List<st_course> getCoursesByStudentId(int st_id) {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
	            .addAnnotatedClass(st_course.class)
	            .buildSessionFactory();
	    Session session = null;
	    Transaction tx = null;
	    List<st_course> courses = null;

	    try {
	        session = factory.getCurrentSession();
	        tx = session.beginTransaction();

	   
			Query query = session.createQuery("FROM st_course WHERE st_id = :st_id");
	        query.setParameter("st_id", st_id);
	        courses = (List<st_course>) query.list();

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

	    return courses;
	}



}
