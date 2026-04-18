package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The media is already in the cart");
        }
    }
	public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media is not in the cart");
        }
    }
	public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }
	public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }
	public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No match found for ID: " + id);
    }
	public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            // Lưu ý: Bạn cần đảm bảo class Media cũng có hàm isMatch 
            // hoặc ép kiểu về DVD nếu chỉ muốn tìm DVD
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
            if (media.isMatch(title)) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No match found for title: " + title);
    }
	
}
