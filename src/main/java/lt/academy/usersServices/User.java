package lt.academy.usersServices;

import lt.academy.generator.Generator;
import lt.academy.entities.Cart;
import lt.academy.entities.Item;
import lt.academy.exceptions.UnavailableDeliveryDateException;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class User implements Generator {

    private String name;
    private String surname;
    private String cardNo;
    private String address;
    private static int userID;
    private int maxOrderAmount;
    private Cart cart;
    private LocalDate deliveryDate;

    Random randomID = new Random();

    public User(String name, String surname, String cardNo, String address) {
        this.name = name;
        this.surname = surname;
        this.cardNo = cardNo;
        this.address = address;
        this.userID = generate();
        this.maxOrderAmount = getMaxAmount();
        this.cart = new Cart();
        this.deliveryDate = deliveryDate;
    }

    @Override
    public int generate() {
        int ID = randomID.nextInt(1000);
        return ID;
    }

    public void addItemToCart(Item item) {
        cart.getItemsCart().add(item);
        item.setItemStock(item.getItemStock()-1);
    }
    public void removeItemFromCart (Item item){
        cart.getItemsCart().remove(item);
        item.setItemStock(item.getItemStock()+1);
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

    public int getMaxAmount() {
        return maxOrderAmount;
    }

    public int getUserID() {
        return userID;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }



}