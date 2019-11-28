package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Usuario
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration con = new Configuration().configure();
            sessionFactory = con.buildSessionFactory();
        } catch (Throwable ex) {
            
            throw(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        Session so = sessionFactory.openSession();

        return so;
    }

    public static void cerrarSession() {
        sessionFactory.close();
    }
}
