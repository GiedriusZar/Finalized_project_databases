package lt.academy.services;

import lt.academy.entities.User;
import lt.academy.hibernate.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {

    public User getById(Long id) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        User user = null;
        try {
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return user;
    }

    public void save(User user){
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

    }
}
