package lt.academy.entities;

import lt.academy.hibernate.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "cart_items", joinColumns = {
            @JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Item> itemsCart;

    public Cart() {
        itemsCart = new ArrayList<>();
    }

    public Cart(User user, LocalDateTime created_at) {
        this.user = user;
        this.created_at = created_at;
    }

    public List<Item> getItemsCart() {
        return itemsCart;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public static Cart create(Cart cart) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(cart);
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
