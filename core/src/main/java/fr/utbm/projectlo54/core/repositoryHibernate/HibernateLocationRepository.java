package fr.utbm.projectlo54.core.repositoryHibernate;

import fr.utbm.projectlo54.core.entity.Location;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import fr.utbm.projectlo54.core.util.HibernateUtil;

/**
 *
 * @author Emmanuel TOSI
 */
public class HibernateLocationRepository {
    public List<Location> getAllLocation()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List <Location> locationList = null;
        
        try {
           session.beginTransaction();
	   Query query = session.createQuery("from Location l");

           locationList = query.list();
           
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
        return locationList;
    } 
} 
