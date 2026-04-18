package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{ 
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	
	@Override
	public String toString() {
	    return "DVD - " + this.getId() + " - "+this.getTitle() + " - " + this.getCategory() + " - " + 
	           this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
	}
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
}