package hust.soict.hedspi.cart;

import hust.soict.hedspi.aims.media.Media;
import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_COST_TITLE;
import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_TITLE_COST;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private static ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public static void addMedia(Media item) {
        if (itemsOrdered.size() >=  MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            itemsOrdered.add(item);
            System.out.println(item.getTitle() +  " has been added");
        }
    }
    public static void removeMedia(Media item) {
        if (itemsOrdered.remove(item)) {
            System.out.println(item.getTitle() + " has been removed");
        } else {
            System.out.println("Item was not found");
        }
    }

    public static void removeByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                itemsOrdered.remove(item);
                System.out.println(item.getTitle() + " has been removed");
            }  else {
                System.out.println("Item was not found");
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public static void displayCart() {
        System.out.println("Cart Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.printf("%d. %-20s %.2f%n", i + 1, itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCost());
        }
    }

    public void print() {
        System.out.println("************************CART************************");
        System.out.println("Ordered Items:");

        float totalCost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + item.toString());
            totalCost += item.getCost();
        }

        System.out.println("Total cost: " + totalCost);
        System.out.println("***************************************************");
    }

    public static void searchByID(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println(item);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The item was not found");
        }
    }

    public static void searchByTitle(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.equals(title)) {
                System.out.println(item);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The item was not found");
        }
    }

    public static void sortByTitleCost() {
        itemsOrdered.sort(COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title then cost.");
    }

    public static void sortByCostTitle() {
        itemsOrdered.sort(COMPARE_BY_COST_TITLE);
        System.out.println("Sorted by cost then title.");
    }

}