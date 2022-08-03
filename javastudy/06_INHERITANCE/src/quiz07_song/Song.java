package quiz07_song;

public class Song {
	
	private String title;
	private double playTIme;
	
	public Song(String title, double playTIme) {		// 생성자
		super();
		this.title = title;
		this.playTIme = playTIme;
	}

	@Override			//generate to string
	public String toString() {
		return "Song [title=" + title + ", playTIme=" + playTIme + "]";
	}

	
	
	
	
	

}
