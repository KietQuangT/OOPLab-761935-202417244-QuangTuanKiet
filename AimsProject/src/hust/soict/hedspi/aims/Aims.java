package hust.soict.hedspi.aims;

import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new CompactDisc("Star Wars", "Sci-Fi", 24.95f, "George Lucas"));
        store.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));

        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Good bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        boolean back = false;
        while (!back) {
            store.print();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCartFromStore();
                    break;
                case 3:
                    playMediaFromStore();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4: ");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.fetchMedia(title);

        if (media != null) {
            System.out.println(media.toString());
            boolean back = false;
            while (!back) {
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media type cannot be played.");
                        }
                        break;
                    case 0:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2: ");
    }

    public static void addMediaToCartFromStore() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.fetchMedia(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found in store!");
        }
    }

    public static void playMediaFromStore() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.fetchMedia(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media type cannot be played.");
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void updateStore() {
        System.out.println("\n1. Add Media to Store");
        System.out.println("2. Remove Media from Store");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            // Bước 1: Hỏi xem muốn thêm loại nào
            System.out.println("\nWhat type of media do you want to add?");
            System.out.println("1. Book");
            System.out.println("2. CD");
            System.out.println("3. DVD");
            System.out.print("Choose option: ");
            int type = scanner.nextInt();
            scanner.nextLine();

            // Bước 2: Nhập các thông tin chung
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter cost: ");
            float cost = scanner.nextFloat();
            scanner.nextLine(); // Chống trôi lệnh

            // Bước 3: Nhập thông tin riêng và tạo đối tượng
            if (type == 1) {
                store.addMedia(new Book(title, category, cost));
            } else if (type == 2) {
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                store.addMedia(new CompactDisc(title, category, cost, artist));
            } else if (type == 3) {
                System.out.print("Enter director: ");
                String director = scanner.nextLine();
                System.out.print("Enter length: ");
                int length = scanner.nextInt();
                scanner.nextLine(); // Chống trôi lệnh
                store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
            } else {
                System.out.println("Invalid media type!");
            }

        } else if (choice == 2) {
            // Phần xóa (giữ nguyên logic chuẩn của ông)
            System.out.print("Enter title of media to remove: ");
            String title = scanner.nextLine();
            Media media = store.fetchMedia(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found!");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    public static void seeCurrentCart() {
        boolean back = false;
        while (!back) {
            cart.print();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Chống trôi lệnh

            switch (choice) {
                case 1:
                    // 1. Lọc (Filter)
                    System.out.println("1. Filter by ID");
                    System.out.println("2. Filter by Title");
                    System.out.print("Choose an option: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (filterChoice == 1) {
                        System.out.print("Enter ID to filter: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cart.searchById(id); // Dùng lại hàm đã viết ở các lab trước
                    } else if (filterChoice == 2) {
                        System.out.print("Enter title to filter: ");
                        String title = scanner.nextLine();
                        cart.searchByTitle(title); // Dùng lại hàm đã viết ở các lab trước
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 2:
                    // 2. Sắp xếp (Sort)
                    System.out.println("1. Sort by Title\n2. Sort by Cost");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) cart.sortByTitle();
                    else if (sortChoice == 2) cart.sortByCost();
                    break;
                case 3:
                    // 3. Xóa (Remove)
                    System.out.print("Enter title to remove from cart: ");
                    String titleToRemove = scanner.nextLine();
                    Media mediaToRemove = cart.fetchMedia(titleToRemove);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Media not found in cart!");
                    }
                    break;
                case 4:
                    // 4. Phát (Play)
                    System.out.print("Enter title to play from cart: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = cart.fetchMedia(titleToPlay);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            ((Playable) mediaToPlay).play();
                        } else {
                            System.out.println("This media type cannot be played.");
                        }
                    } else {
                        System.out.println("Media not found in cart!");
                    }
                    break;
                case 5:
                    // 5. Đặt hàng (Place order)
                    System.out.println("An order has been created. The cart will now be emptied.");
                    cart.empty();
                    back = true;
                    break;
                case 0:
                    // 0. Quay lại (Back)
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5: ");
    }
}