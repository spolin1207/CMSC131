package mediaRentalManager;

/**
 * Subclass of Media
 * Defines parameters specific to music
 * @author Sujay Polineni
 *
 */

public class Albums extends Media{
	
	/**
	 * Defines variables specific to songs
	 */
	
	private String artist;
	private String songs;
	
	/**
	 * Initializes variables
	 * @param title
	 * @param copies
	 * @param artist
	 * @param songs
	 */
	public Albums(String title, int copies, String artist, String songs) {
		super(title, copies);
		this.artist = artist;
		this.songs = songs;
	}
	
	/**
	 * String output that will be returned for music
	 */
	@Override
	public String toString() {
		return "Title: " + this.getTitle() + ", Copies Available: " + this.getCopies() + ", Artist: " + artist + ", Songs: " + songs;
	}

	/**
	 * Returns the name of the artist
	 * @return
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sets artist parameter
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Returns the songs
	 * @return
	 */
	public String getSongs() {
		return songs;
	}

	/**
	 * Sets the songs parameter
	 * @param songs
	 */
	public void setSongs(String songs) {
		this.songs = songs;
	}
}
