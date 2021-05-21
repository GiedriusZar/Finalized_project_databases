package lt.academy.services;
import lt.academy.entities.Cart;
import lt.academy.entities.User;
import lt.academy.hibernate.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public User save(User user) {
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
        Cart.create(new Cart(user, LocalDateTime.now()));
        return user;

    }

    public List<User> getAllByName(String firstName) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = new ArrayList<>();
        try {
            Query<User> query = session.createQuery("FROM User WHERE firstName = :firstName", User.class);
            query.setParameter("firstName", firstName);
            transaction.commit();
            users = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return users;
    }

}
