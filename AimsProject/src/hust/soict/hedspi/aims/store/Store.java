package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class Store {
	public static final int MAX_ITEMS_IN_STORE=1000;
	private DigitalVideoDisc itemsInStore[] =
			new DigitalVideoDisc [MAX_ITEMS_IN_STORE];
	private int qtyItem = 0;
	public void addDVD(DigitalVideoDisc disc) {
		if (qtyItem<MAX_ITEMS_IN_STORE) {
			itemsInStore[qtyItem++] = disc;
			System.out.println("The disc has been added\n");
		} else 
			System.out.println("The store is full");
	}
	public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;

        for (int i = 0; i < qtyItem; i++) {
            if (itemsInStore[i] == disc) {
                for (int j = i; j < qtyItem - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[--qtyItem] = null;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The disc has been removed");
        } else {
            System.out.println("The disc was not found");
        }
    }

	public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in the store:");
        for (int i = 0; i < qtyItem; i++) {
	        System.out.println((i + 1) + ". " + itemsInStore[i].toString());
	    }
        System.out.println("***************************************************");
    }
}
