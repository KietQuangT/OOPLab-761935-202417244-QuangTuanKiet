package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc { 
	private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title); // Dùng hàm Setter thay vì gọi trực tiếp biến
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director); // director là biến riêng của DVD nên vẫn dùng this.director bình thường
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director); 
		this.setLength(length);     // length cũng là biến riêng nên dùng this.length
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	
	@Override
	public String toString() {
	    return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + 
	           this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
	}
	
	public boolean isMatch(String title) {
	    // So sánh không phân biệt chữ hoa chữ thường
	    return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}
}