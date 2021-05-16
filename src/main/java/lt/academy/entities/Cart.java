package lt.academy.entities;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

//    @ManyToOne()
//    private User user;

    @Column(name = "user_id")
    private Long userId;


    @Column(name = "created_at")
    private LocalDateTime created_at;


//    List<Item> itemsCart;
//
    public Cart() {
}
//        itemsCart = new ArrayList<>();
//
//    }
//
//    public List<Item> getItemsCart() {
//        return itemsCart;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
