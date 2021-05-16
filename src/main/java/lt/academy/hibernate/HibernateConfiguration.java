package lt.academy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {


    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static Session openSession() {
        return factory.openSession();
    }


}
