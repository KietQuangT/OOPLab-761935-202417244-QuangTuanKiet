package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors= new ArrayList<String>();
	
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

	public List<String> getAuthors() {
		return authors;
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
		
		
	}
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("The author has been added");
		} else {
			System.out.println("The author has been already in the list");
		}
	}
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName); // Xóa trực tiếp bằng tên
			System.out.println("The author has been removed");
		} else {
			System.out.println("The author is not present in the list");
		}
	}

}
