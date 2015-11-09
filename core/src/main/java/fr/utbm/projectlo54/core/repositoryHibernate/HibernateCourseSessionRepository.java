/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projectlo54.core.repositoryHibernate;

import fr.utbm.projectlo54.core.entity.CourseSession;
import fr.utbm.projectlo54.core.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author java
 */
public class HibernateCourseSessionRepository {
     public List<CourseSession> getListCourseSession(int min, int max)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> courseSessionList = null;
        
        try {
           session.beginTransaction();
	   Query query = session.createQuery("from CourseSession cs");
           query.setFirstResult(min);
           query.setMaxResults(max);
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
