package fr.utbm.projectlo54.core.client;

import fr.utbm.projectlo54.core.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Emmanuel TOSI
 */
public class App0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        
    }
    
}
