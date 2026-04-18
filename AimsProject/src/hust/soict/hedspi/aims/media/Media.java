package hust.soict.hedspi.aims.media;
import java.util.Comparator;
public abstract class Media {
	private static int nbMedia=0;
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE=
			new MediaComparatorByCostTitle();
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	public Media(String title) {
		this.title=title;
		nbMedia++;
		this.id=nbMedia;
	}
	public Media(String title, String category, float cost) {
		this.title=title;
		this.category=category;
		this.cost=cost;
		nbMedia++;
		this.id=nbMedia;
	} 
	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isMatch(String title) {
	    // So sánh không phân biệt chữ hoa chữ thường
	    return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}
	
	@Override
	public boolean equals(Object o) {
	    if (!(o instanceof Media)) {
	        return false; 
	    }
	    Media other = (Media) o;
	    
	    if (this.title == null || other.title == null) return false;
	    return this.title.equalsIgnoreCase(other.getTitle());
	}
	
}
