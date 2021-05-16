package lt.academy.services;

import lt.academy.entities.Cart;
import lt.academy.entities.User;
import lt.academy.hibernate.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CartService {

    public Cart getById(Long id) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = null;
        try {
            cart = session.get(Cart.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return cart;
    }
}
