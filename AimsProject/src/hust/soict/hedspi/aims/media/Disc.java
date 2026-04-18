package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media{
	private String director;
	private int length;
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}

}
