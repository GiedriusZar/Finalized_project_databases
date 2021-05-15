package lt.academy.usersServices;

import lt.academy.entities.Cart;
import lt.academy.entities.Item;
import lt.academy.exceptions.UnavailableDeliveryDateException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
@Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "card_number")
    private String cardNo;
    @Column(name = "address")
    private String address;
    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    private String name;
    private String surname;
    //    private String cardNo;
//    private String address;
    private static int userID;
    private Cart cart;
//    private LocalDate deliveryDate;


    public User() {
    }

    public User(String name, String surname, String cardNo, String address) {
        this.name = name;
        this.surname = surname;
        this.cardNo = cardNo;
        this.address = address;
        this.cart = new Cart();
        this.deliveryDate = deliveryDate;
    }


    public void addItemToCart(Item item) {
        cart.getItemsCart().add(item);
        item.setItemStock(item.getItemStock() - 1);
    }

    public void removeItemFromCart(Item item) {
        cart.getItemsCart().remove(item);
        item.setItemStock(item.getItemStock() + 1);
    }

    public List showCart() {
        return cart.getItemsCart();
    }

    public void changeDate(LocalDate newDate) throws UnavailableDeliveryDateException {
        if (newDate.getDayOfYear() - deliveryDate.getDayOfYear() <= 5) {
            throw new UnavailableDeliveryDateException("You can't change order date");
        } else {
            this.deliveryDate = newDate;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


}