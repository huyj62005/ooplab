package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private static int MAX_NUMBERS_IN_STORE = 50;
    private static ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public static void addMedia(Media item) {
        if (itemsInStore.size() >=  MAX_NUMBERS_IN_STORE) {
            System.out.println("The store is full");
        } else {
            itemsInStore.add(item);
            System.out.println(item.getTitle() +  " has been added");
        }
    }

    public static void removeMedia(Media item) {
        if (itemsInStore.remove(item)) {
            System.out.println(item.getTitle() + " has been removed");
        } else {
            System.out.println("Item was not found");
        }
    }

    public static Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return new ArrayList<>(itemsInStore);
    }

    public void printStore() {
        System.out.println("************************Store************************");
        System.out.println("Stored Items:");

        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }

        System.out.println("***************************************************");
    }
}