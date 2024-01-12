package com.city;

import java.util.List;
import java.util.Random;

import javax.persistence.NamedQueries;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.city.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	
        	SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        	
        	Session session=sessionFactory.openSession();
        	session.getTransaction().begin();
        	session.save(new Student(new Random().nextInt(100000), "Mary", "public", "mary@email.com"));
        	TypedQuery<Student> queries=session.createQuery("FROM Student S",Student.class);
        	List<Student> list=queries.getResultList();
        	
        	for(Student s:list)
        	{
        		System.out.println(s);
        	}
        	session.getTransaction().commit();
        	System.out.println("done");
        	
        	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
