package lt.academy.services;

import lt.academy.entities.Item;
import lt.academy.entities.User;
import lt.academy.hibernate.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ItemService {

    public Item getById(Long id) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        Item item = null;
        try {
            item = session.get(Item.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return item;
    }

    public List<Item> getAll() {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        List<Item> items = new ArrayList<>();
        try {
            Query<Item> query = session.createQuery("FROM Item", Item.class);
            transaction.commit();
            items = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return items;

    }

    public Item save(Item item) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(item);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return item;
    }

    public void delete(Item item) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(item);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
