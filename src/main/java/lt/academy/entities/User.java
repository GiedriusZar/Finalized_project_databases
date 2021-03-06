package lt.academy.entities;

import lt.academy.exceptions.UnavailableDeliveryDateException;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    private Cart cart;

    public User() {
    }

    public User(String firstName, String lastName, String cardNo, String address, LocalDate deliveryDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNo = cardNo;
        this.address = address;
        this.cart = new Cart();
        this.deliveryDate = null;
    }


        public void addItemToCart(Item item) {
        cart.getItemsCart().add(item);
    }

    public void removeItemFromCart(Item item) {
        cart.getItemsCart().remove(item);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", address='" + address + '\'' +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}