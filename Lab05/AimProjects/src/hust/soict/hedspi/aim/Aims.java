package hust.soict.hedspi.aim;

import hust.soict.hedspi.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

import java.util.Scanner;

public class Aims {
		public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                break;

            case 1:
                storeMenu();
                break;

            case 2:
                updateStoreMenu();
                break;

            case 3:
                Cart.displayCart();
                cartMenu();
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.println("Enter the title of the media: ");
                String title = scanner.nextLine();
                Media media = Store.search(title);
                if (media != null) {
                    System.out.println(media);
                    mediaDetailsMenu();
                } else {
                    System.out.println("Invalid title");
                }
                break;

            case 2:
                System.out.println("Enter the title of the media: ");
                title = scanner.nextLine();
                media = Store.search(title);
                if (media != null) {
                    Cart.addMedia(media);
                } else {
                    System.out.println("Invalid title");
                }
                break;

            case 3:
                System.out.println("Enter the title of the media: ");
                title = scanner.nextLine();
                media = Store.search(title);
                if (media != null) {
                    // play the media
                } else {
                    System.out.println("Invalid title");
                }
                break;

            case 4:
                Cart.displayCart();
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("------------------");
        System.out.println("Please choose a number: 0-1-2");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.println("Enter the title of the media: ");
                String title = scanner.nextLine();
                Media media = Store.search(title);
                if (media != null) {
                    Cart.addMedia(media);
                } else {
                    System.out.println("Invalid title");
                }
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filterMediaInCart();
                break;

            case 2:
                sortMediaInCart();
                break;

            case 3:
                System.out.println("Enter the title of the media: ");
                String title = scanner.nextLine();
                Cart.removeByTitle(title);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void updateStoreMenu() {
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the title of the media: ");
                String title = scanner.nextLine();
                Media media = Store.search(title);
                if (media != null) {
                    System.out.println("The media exists");
                } else {
                    Store.addMedia(media);
                    System.out.println("The media is successfully added");
                }
                break;

            case 2:
                System.out.println("Enter the title of the media: ");
                title = scanner.nextLine();
                media = Store.search(title);
                if (media != null) {
                    Store.removeMedia(media);
                    System.out.println("The media is successfully removed");
                } else  {
                    System.out.println("Invalid title");
                }
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void filterMediaInCart() {
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter ID: ");
                int id = scanner.nextInt();
                Cart.searchByID(id);
                break;

            case 2:
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                Cart.searchByTitle(title);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void sortMediaInCart() {
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Cart.sortByTitleCost();
                Cart.displayCart();
                break;

            case 2:
                Cart.sortByCostTitle();
                Cart.displayCart();
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }

    }

}