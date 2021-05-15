package lt.academy;

import lt.academy.enums.ItemType;
import lt.academy.exceptions.NoIdException;
import lt.academy.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsBase {

    private List<Item> allItems = new ArrayList<>();

    Item item1 = new Item("FISHING", "Fishing rod", "257", 99, 5);
    Item item2 = new Item("CLOTHES", "Shoes", "277", 35, 32);
    Item item3 = new Item("DRINKS", "Whiskey Blue Label", "47", 189, 10);
    Item item4 = new Item("GARDENING", "Seeds", "144", 2, 255);
    Item item5 = new Item("ELECTRICITY", "Wires", "234", 11, 58);
    Item item6 = new Item("ELECTRICITY", "Box of light bulbs", "345", 48, 19);
    Item item7 = new Item("FISHING", "Fishing reel", "147", 139, 7);
    Item item8 = new Item("CLOTHES", "Pants", "167", 35, 35);
    Item item9 = new Item("DRINKS", "Whiskey Black Label", "48", 39, 60);
    Item item10 = new Item("FURNITURE", "Sofa", "687", 225, 3);
    Item item11 = new Item("FURNITURE", "Table", "299", 48, 34);
    Item item12 = new Item("FURNITURE", "Bed", "111", 625, 10);
    Item item13 = new Item("FURNITURE", "Sink", "399", 335, 5);
    Item item14 = new Item("FISHING", "Platform", "322", 299, 7);
    Item item15 = new Item("DRINKS", "Apple juice", "32", 3, 300);
    Item item16 = new Item("GARDENING", "Shovel", "102", 79, 16);
    Item item17 = new Item("GARDENING", "Gloves", "479", 1, 144);
    Item item18 = new Item("FISHING", "Worms", "170", 2, 188);

    public ItemsBase() {
        addAllItems();
    }


    public List<Item> getAllItems() {
        return allItems;
    }

    public List<Item> addAllItems() {

        allItems.add(item1);
        allItems.add(item2);
        allItems.add(item3);
        allItems.add(item4);
        allItems.add(item5);
        allItems.add(item6);
        allItems.add(item7);
        allItems.add(item8);
        allItems.add(item9);
        allItems.add(item10);
        allItems.add(item11);
        allItems.add(item12);
        allItems.add(item13);
        allItems.add(item14);
        allItems.add(item15);
        allItems.add(item16);
        allItems.add(item17);
        allItems.add(item18);

        return allItems;
    }

    public Item getItem(String id) throws NoIdException {
        Item tempItem = null;
        for (Item item : allItems) {
            if (item.getItemID().equals(id)) {
                tempItem = item;
            }}
        if (tempItem == null) {
            throw new NoIdException("No such ID exists");
        }
        return tempItem;
    }


    @Override
    public String toString() {
        return "ItemsBase{" +
                "allItems=" + allItems +
                '}';
    }
}
