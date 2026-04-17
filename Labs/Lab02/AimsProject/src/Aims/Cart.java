package Aims;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println("The disc has been added\n");
		} else 
			System.out.println("The cart is almost full");
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i=0;i<qtyOrdered;i++)
			if (disc==itemsOrdered[i]){
				for (int j=i;j<qtyOrdered-1;j++)
					itemsOrdered[j]=itemsOrdered[j+1];
				itemsOrdered[--qtyOrdered]=null;
				i--;
			}
		System.out.println("The disc has been removed\n");
	}
	public float totalCost() {
		float sum=0;
		for (int i=0;i<qtyOrdered;i++)
			sum+=itemsOrdered[i].getCost();
		return sum;
	}
	public void displayCartItems() {
		if (qtyOrdered!=0) {
			for (int i=0;i<qtyOrdered;i++)
				System.out.printf("%-3d %-20s %-10.2f\n", (i + 1), itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
		} else
			System.out.println("None");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered+dvdList.length-1 < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) { 
					itemsOrdered[qtyOrdered++] = dvdList[i];
					System.out.println("The discs has been added");
			}
		} else
			System.out.println("The cart is almost full");
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
		if (qtyOrdered+1<MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = dvd1;
			itemsOrdered[qtyOrdered++] = dvd2;
			System.out.println("The discs has been added\n");
		} else 
			System.out.println("The cart is almost full");
	}
	
}
