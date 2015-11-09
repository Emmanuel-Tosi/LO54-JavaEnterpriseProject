
package fr.utbm.projectlo54.core.repositoryHibernate;

import fr.utbm.projectlo54.core.entity.Course;
import fr.utbm.projectlo54.core.entity.CourseSession;
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
    public List<CourseSession> getByCriteria(String keyword, Date date, Location location)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> courseSessionList = null;
        
        String queryString = "from Course c";
        
        if (keyword != null)
        {
            queryString = queryString + "where ";
        }
        
        if (date != null)
        {
            queryString = queryString + "where ";
        }
        
        if (location != null)
        {
            queryString = queryString + "where ";
        }
        
        
        try {
           session.beginTransaction();
	   Query query = session.createQuery(queryString);
           query.setParameter(0, keyword);
           courseSessionList = query.list();
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
        return courseSessionList;
    } 
}
