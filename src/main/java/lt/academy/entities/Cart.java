package lt.academy.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    private Long id;
    private String owner;
    private LocalDateTime created_at;




    List<Item> itemsCart;

    public Cart() {
        itemsCart = new ArrayList<>();

    }

    public List<Item> getItemsCart() {
        return itemsCart;
    }
}
