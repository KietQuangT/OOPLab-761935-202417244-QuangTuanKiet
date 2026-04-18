package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	// Thêm bài hát
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Đã thêm track: " + track.getTitle());
        } else {
            System.out.println("Track này đã có trong CD!");
        }
    }
    
 // Xóa bài hát
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa track: " + track.getTitle());
        } else {
            System.out.println("Không tìm thấy track này trong CD!");
        }
    }
    public int getLength() {
        int totalLength = 0;
        // Duyệt qua từng bài hát trong danh sách
        for (Track track : tracks) {
            totalLength += track.getLength(); // Lấy thời lượng từng bài cộng dồn vào
        }
        return totalLength;
    }

}
