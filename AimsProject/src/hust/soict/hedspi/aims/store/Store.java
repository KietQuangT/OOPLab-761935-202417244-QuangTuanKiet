package hust.soict.hedspi.aims.store;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
public class Store {
	private ArrayList<Media> itemsInStore=new ArrayList<Media>();
	
	public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media has been added to the store.");
        } else {
            System.out.println("This media already exists in the store.");
        }
    }
	public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("The media is not found in the store.");
        }
    }
	public void print() {
	    System.out.println("***********************STORE***********************");
	    System.out.println("Items in the store:");
	   
	    for (int i = 0; i < itemsInStore.size(); i++) {
	        System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
	    }
	    
	    System.out.println("***************************************************");
	}
	public Media fetchMedia(String title) {
	    for (Media m : itemsInStore) {
	        if (m.getTitle().equalsIgnoreCase(title)) {
	            return m;
	        }
	    }
	    return null; // Không tìm thấy
	}
}
