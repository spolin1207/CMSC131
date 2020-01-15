package mediaRentalManager;

/**
 * Superclass that contains information about media that can be rented
 * A class that is used for the functionality of MediaRentalManager
 * @author Sujay Polineni
 *
 */

public class Media {
	
	/**
	 * Defines variables specific to all types of media
	 */
	
	private String title;
	private int copies;
	
	/**
	 * Initializes variables
	 * @param title
	 * @param copies
	 */
	public Media(String title, int copies) {
		this.title = title;
		this.copies = copies;
	}

	/**
	 * Returns the title parameter
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title parameter
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the number of copies
	 * @return
	 */
	public int getCopies() {
		return copies;
	}

	/**
	 * Sets the copies parameter
	 * @param copies
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}
	

}
