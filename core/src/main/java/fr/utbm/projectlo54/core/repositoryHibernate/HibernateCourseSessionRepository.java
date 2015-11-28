package fr.utbm.projectlo54.core.repositoryHibernate;

import fr.utbm.projectlo54.core.entity.CourseSession;
import fr.utbm.projectlo54.core.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emmanuel TOSI
 */
public class HibernateCourseSessionRepository {
    
    public List<CourseSession> getByCriteria(String keyword, Date date, String cityLocation)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> courseSessionList = null;
        int passage = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String queryString = "from CourseSession cs ";
        
        if (keyword != null)
        {
            queryString = queryString + "where cs.courseCode.title like '%" + keyword + "%'";
            passage = 1;
        }
        
        if (date != null)
        {
            if (passage == 0)
            {
                queryString = queryString + " where ";
            }
            else 
            {
                queryString = queryString + " and ";
            }
            
            queryString = queryString + " cs.startDate > '" + simpleDateFormat.format(date) + "'";
            passage = 1;
           
        }
        
        if (cityLocation != null)
        {
            if (passage == 0)
            {
                queryString = queryString + " where ";
            }
            else 
            {
                queryString = queryString + " and ";
            }
            
            queryString = queryString + " cs.locationId.city = '" + cityLocation + "'";
        }
        
        System.out.println(queryString);
        
        try {
           session.beginTransaction();
	   Query query = session.createQuery(queryString);

           courseSessionList = query.list();
           
           for(int i = 0; i < courseSessionList.size(); i++) {
            Hibernate.initialize((courseSessionList.get(i)).getCourseCode());
            Hibernate.initialize((courseSessionList.get(i)).getLocationId());
           }
           
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
    
    public List<CourseSession> getListCourseSession(int min, int max)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> courseSessionList = null;
        
        try {
           session.beginTransaction();
	   Query query = session.createQuery("from CourseSession cs join fetch cs.locationId join fetch cs.courseCode");
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
    
    public CourseSession getById(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseSession courseFound = null;
        
        try {
           session.beginTransaction();
	   Query query = session.createQuery("from CourseSession cs where cs.id = ?");
           query.setParameter(0,id);
           courseFound = (CourseSession) query.uniqueResult();
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
        return courseFound;
    }   
}
