
package fr.utbm.projectlo54.core.repositoryHibernate;

import fr.utbm.projectlo54.core.entity.Course;
import fr.utbm.projectlo54.core.entity.Location;
import fr.utbm.projectlo54.core.util.HibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java
 */
public class HibernateCourseRepository {
    
    public List<Course> getByKeyword(String keyword)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courseList = null;
        try {
           session.beginTransaction();
	   Query query = session.createQuery("from Course c where Title = ?");
           query.setParameter(0, keyword);
           courseList = query.list();
           session.getTransaction().commit();
	} catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                } catch(HibernateException he2) {
                    he2.printStackTrace();
                } 
            }
        } finally {
            if(session != null) {
                try { session.close();

                }
                catch (HibernateException he) {
                }
            }
        }
        return courseList;
    }
    
    public List<Course> getByDate(Date date)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courseList = null;
        try {
            
	   Query query = session.createQuery("Select Course from CourseSession c where startDate = ?");
           query.setParameter(0, date);
           courseList = query.list();
           
	} catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                } catch(HibernateException he2) {
                    he2.printStackTrace();
                } 
            }
        } finally {
            if(session != null) {
                try { session.close();

                }
                catch (HibernateException he) {
                }
            }
        }
        return courseList;
    }
    
    public List<Course> getByLocation(Location location)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courseList = null;
        try {
            
	   Query query = session.createQuery("Select Course from CourseSession c where location = ?");
           query.setParameter(0, location);
           courseList = query.list();
           
	} catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                } catch(HibernateException he2) {
                    he2.printStackTrace();
                } 
            }
        } finally {
            if(session != null) {
                try { session.close();

                }
                catch (HibernateException he) {
                }
            }
        }
        return courseList;
    }
}
