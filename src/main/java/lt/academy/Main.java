package lt.academy;

import lt.academy.entities.Cart;
import lt.academy.exceptions.CardNoLengthException;
import lt.academy.exceptions.DayOfWeekException;
import lt.academy.exceptions.UnavailableDeliveryDateException;
import lt.academy.entities.Item;
import lt.academy.hibernate.HibernateConfiguration;
import lt.academy.entities.User;
import org.hibernate.Session;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws DayOfWeekException, CardNoLengthException {
        Session session = HibernateConfiguration.getSession();
        User user1 = new User("Tom", "Thompson", "8574698521036587", "Vilnius");
        user1.setDeliveryDate(LocalDate.of(2021, 05, 16));
        session.save(user1);


        Item item = new Item();
        ItemsBase allItemBase = new ItemsBase();

        Scanner scanner = new Scanner(System.in);

        String menuInput = "";

        System.out.println("REGISTRATION");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Card number: ");
        String cardNo = scanner.nextLine();
//        if (cardNo.length() != 16) {
//            throw new CardNoLengthException("Invalid card number") {
//            };
//        }
        System.out.print("Address: ");
        String address = scanner.nextLine();
        User user = new User(name, surname, cardNo, address);


        while (!menuInput.equals("7")) {
            userMenu();
            menuInput = scanner.nextLine();


            switch (menuInput) {

                case "1":
                    System.out.println(allItemBase.getAllItems());
                    break;
                case "2":
                    System.out.print("Enter item ID You want to add to Your cart: ");
                    String choice = scanner.nextLine();
//                    try {
//                        user.addItemToCart(allItemBase.getItem(choice));
//                    } catch (NoIdException e) {
//                        System.out.println(e.getMessage());
//                    }
                    break;
                case "3":
//                    System.out.println(user.showCart());
                    break;
                case "4":
                    System.out.println("Enter item ID from Your cart You want ");
                    String itemId = scanner.nextLine();
//                    try {
//                        user.removeItemFromCart(allItemBase.getItem(itemId));
//                    } catch (NoIdException e) {
//                        System.out.println(e.getMessage());
//                    }
                    break;
                case "5":
                    if (user.getDeliveryDate() == null) {
                        System.out.println("\n \t\t\t\t\t\t\t IMPORTANT!! \n You can't change order date if Your delivery will arive in less than 5 days\n\n How many days from now would You like Your dellivery to arrive?");
                        int days = scanner.nextInt();
                        user.setDeliveryDate(LocalDate.now().plusDays(days));
                        if (user.getDeliveryDate().getDayOfWeek() == DayOfWeek.SATURDAY || user.getDeliveryDate().getDayOfWeek() == DayOfWeek.SUNDAY) {
                            throw new DayOfWeekException("We dont deliver items on weekends");
                        } else {
                            System.out.println("Your dellivery will arrive at: " + user.getDeliveryDate());
                        }
                    } else {
                        System.out.println("Your order date has already been accepted");
                    }
                    break;
                case "6":
                    if (user.getDeliveryDate() == null) {
                        System.out.println("There is no delivery date");
                    } else {
                        System.out.println("If You want to change delivery time, enter how many days from now would You like Your items to be delivered");
                        int newDays = scanner.nextInt();
                        try {
                            user.changeDate(LocalDate.now().plusDays(newDays));
                        } catch (UnavailableDeliveryDateException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Your delivery date is: " + user.getDeliveryDate());
                        }
                    }
                    break;
                case "7":
                    break;
            }
        }
    }


    private static void mainMenu() {
        String format = String.format("%15s", "MENU");
        System.out.println();
        System.out.println(format);
        System.out.println();
        System.out.println("1 - Registration");
        System.out.println("2 - Login");
        System.out.println("3 - Exit");
    }

    private static void userMenu() {
        String format = String.format("%15s", "MENU");
        System.out.println();
        System.out.println(format);
        System.out.println();
        System.out.println("1 - See available items");
        System.out.println("2 - Add items to my cart");
        System.out.println("3 - Check my cart");
        System.out.println("4 - Remove items from my cart");
        System.out.println("5 - Set order date");
        System.out.println("6 - Change order date");
        System.out.println("7 - Exit");
    }

//        private static void adminMenu () {
//            String format = String.format("%15s", "MENU");
//            System.out.println();
//            System.out.println(format);
//            System.out.println();
//            System.out.println("1 - Register");
//            System.out.println("2 - Login");
//            System.out.println("3 - Exit");
//        }

}

