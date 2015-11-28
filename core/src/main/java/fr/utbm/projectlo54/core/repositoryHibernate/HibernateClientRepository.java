package fr.utbm.projectlo54.core.repositoryHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import fr.utbm.projectlo54.core.util.HibernateUtil;
import fr.utbm.projectlo54.core.entity.Client;

/**
 *
 * @author Emmanuel TOSI
 */
public class HibernateClientRepository {
    public void save(Client newClient)
    {   
       	Session session = HibernateUtil.getSessionFactory().openSession();
	try {
	    session.beginTransaction();
	    session.persist(newClient);
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
    }
}