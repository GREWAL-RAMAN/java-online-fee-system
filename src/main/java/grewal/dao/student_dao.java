package grewal.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import grewal.bean.student;
import grewal.bean.st_course;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class student_dao {
	@SuppressWarnings("deprecation")
	public void  addStudent(student my) {
		
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
	                .buildSessionFactory();
					
		Session mySession=factory.getCurrentSession();
		try {
			mySession.beginTransaction();
			mySession.save(my);
			mySession.getTransaction().commit();
			System.out.println("student added ->");
			System.out.println(my);
		} finally {
			mySession.close();
			factory.close();
		}
	}
	public student getStudent(int id)
	{
		student my_s;
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
		my_s=mySession.get(student.class,id);
	
		System.out.println("student returned ->");
		System.out.println(my_s);
	} finally {
		mySession.close();
		factory.close();
	}
		return my_s;
	}
	public student updateStudent(student my_s,int id)
	{
		student my=new student();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(student.class,id);
		System.out.println("Student to updated");
		System.out.println(my);
	     my.setStudent(my_s);
	    mySession.getTransaction().commit(); 
		System.out.println("student updated ->");
		System.out.println(my);
	} finally {
		mySession.close();
		factory.close();
	}				
		return my;
	}
    
	public student deleteStudent(int id)
	{

		student my=new student();
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		
		mySession.beginTransaction();
		my=mySession.get(student.class,id);
		System.out.println("Student to deleted");
		System.out.println(my);
	    mySession.remove(my);
	    mySession.getTransaction().commit(); 
		System.out.println("student deleted ");
	
	} finally {
		mySession.close();
		factory.close();
	}	
		
		return my;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<student> getAllStudent()
	{
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
                .buildSessionFactory();
				
	Session mySession=factory.getCurrentSession();
	try {
		mySession.beginTransaction();
    List<student> students= mySession.createQuery("from student").getResultList();
           if(!students.isEmpty())
           {
        	   return students;
           }
  	
	} finally {
		mySession.close();
		factory.close();
	}
		return null;
	}
//	public List<student> getStudentsNotInCourse() {
//		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class)
//                .buildSessionFactory();
//	    Session session = factory.getCurrentSession();
//	    session.beginTransaction();
//	    String hql = "FROM student s WHERE s.id NOT IN (SELECT c.st_id FROM st_course c)";
//	    Query query = session.createQuery(hql, student.class);
//	    @SuppressWarnings("unchecked")
//		List<student> students = query.getResultList();
//		session.close();
//		factory.close();
//	    return students;
//	}
//
	
	public List<student>  getStudentsNotInCourse() {
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                 .addAnnotatedClass(student.class)
                 .addAnnotatedClass(st_course.class)
                 .buildSessionFactory();
		Session session = factory.getCurrentSession();	
		session.beginTransaction();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<student> criteria = builder.createQuery(student.class);
	    Root<student> rootTable1 = criteria.from(student.class);

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
	public student getMaxIdRecord() {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
	            .addAnnotatedClass(student.class)
	            .buildSessionFactory();
	    Session session = null;
	    student result = null;
	    try {
	        session = factory.getCurrentSession();
	        session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<student> query = builder.createQuery(student.class);
	        Root<student> root = query.from(student.class);
	        query.select(root);
	        query.orderBy(builder.desc(root.get("id")));
	        Query<student> q = session.createQuery(query);
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
