package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();

		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
		        "Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
		        "Science Fiction", "George Lucas", 87, 24.95f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
		        "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("the Lion King",
		        "Animation", "Roger Allers", 87, 19.95f);
		
		Book book1=new Book("Dog");
		book1.addAuthor("KietQuang");
		book1.addAuthor("Gia Kien");
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		anOrder.addMedia(dvd4);
		anOrder.addMedia(book1);
		anOrder.sortByCost();
		anOrder.print();
	}

}
