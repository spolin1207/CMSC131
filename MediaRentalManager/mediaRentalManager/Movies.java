package mediaRentalManager;

/**
 * Subclass of media
 * Defines parameters specific to movies
 * @author Sujay Polineni
 *
 */

public class Movies extends Media{
	
	/**
	 * Defines variables
	 */
	
	private String rating;
	
	/**
	 * Initializes variables
	 * @param title
	 * @param copies
	 * @param rating
	 */
	public Movies(String title, int copies, String rating) {
		super(title, copies);
		this.rating = rating;
	}

	/**
	 * The string that will be returned as output for movies
	 */
	@Override
	public String toString() {
		return "Title: " + this.getTitle() + ", Copies Available: " + this.getCopies() + ", Rating: " + rating;
	}

	/**
	 * Returns rating of a movie
	 * @return
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating
	 * @param rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}	
}
