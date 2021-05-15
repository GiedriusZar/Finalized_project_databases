package lt.academy.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {


    List<Item> itemsCart;

    public Cart() {
        itemsCart = new ArrayList<>();

    }

    public List<Item> getItemsCart() {
        return itemsCart;
    }
}
