package hust.soict.hedspi.aim;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        while (true) {
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                storeMenu();
                break;
            case 2:
                updateStoreMenu();
                break;
            case 3:
                cart.displayCart();
                cartMenu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void storeMenu() {
        System.out.println("Store Menu:");
        System.out.println("------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 0:
                return;
            case 1:
                System.out.print("Enter the title of the media: ");
                String title = scanner.nextLine();
                Media media = store.search(title);
                if (media != null) {
                    System.out.println(media.toString());
                    mediaDetailsMenu(media);
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 2:
                System.out.print("Enter the title of the media: ");
                title = scanner.nextLine();
                media = store.search(title);
                if (media != null) {
                    try {
                        cart.addMedia(media);
                        System.out.println("Added to cart: " + media.getTitle());
                    } catch (LimitExceededException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 3:
                System.out.print("Enter the title of the media: ");
                title = scanner.nextLine();
                media = store.search(title);
                if (media instanceof Playable) {
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null,
                                e.getMessage(),
                                "Illegal DVD Length",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("This media is not playable.");
                }
                break;
            case 4:
                cart.displayCart();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Media Details Menu:");
        System.out.println("------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("------------------");
        System.out.print("Please choose a number: 0-1-2: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 0:
                return;
            case 1:
                try {
                    cart.addMedia(media);
                    System.out.println("Added to cart.");
                } catch (LimitExceededException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                if (media instanceof Playable) {
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null,
                                e.getMessage(),
                                "Illegal DVD Length",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("This media is not playable.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void cartMenu() {
        System.out.println("Cart Menu:");
        System.out.println("------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 0:
                return;
            case 1:
                filterMediaInCart();
                break;
            case 2:
                sortMediaInCart();
                break;
            case 3:
                System.out.print("Enter the title of the media to remove: ");
                String title = scanner.nextLine();
                cart.removeByTitle(title);
                break;
            case 4:
                System.out.print("Enter the title of the media to play: ");
                title = scanner.nextLine();
                Media media = cart.searchByTitle(title);
                if (media instanceof Playable) {
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null,
                                e.getMessage(),
                                "Illegal DVD Length",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("This media is not playable.");
                }
                break;
            case 5:
                System.out.println("Order placed. Thank you!");
                cart.clearCart();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void updateStoreMenu() {
        System.out.println("Update Store Menu:");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // flush newline

        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.search(title);

        switch (choice) {
            case 1:
                if (media != null) {
                    System.out.println("Media already exists.");
                } else {
                    System.out.println("Choose media type: 1. DVD, 2. CD");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // flush

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter cost: ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Enter director: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter length: ");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        media = new DigitalVideoDisc(title, category, director, length, cost);
                    } else {
                        media = new CompactDisc(title, category, cost);
                    }

                    store.addMedia(media);
                    System.out.println("Media added.");
                }
                break;

            case 2:
                if (media != null) {
                    store.removeMedia(media);
                    System.out.println("Media removed.");
                } else {
                    System.out.println("Media not found.");
                }
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void filterMediaInCart() {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                cart.searchByID(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void sortMediaInCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title then Cost");
        System.out.println("2. Cost then Title");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                cart.sortByTitleCost();
                break;
            case 2:
                cart.sortByCostTitle();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        cart.displayCart();
    }
}
