package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MediaRentalManager implements MediaRentalManagerInt {

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Media> media = new ArrayList<Media>();

	@Override
	public void addCustomer(String name, String address, String plan) {
		Customer c = new Customer(name, address, plan);
		customers.add(c);
	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {
		Movies m = new Movies(title, copiesAvailable, rating);
		media.add(m);
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Albums a = new Albums(title, copiesAvailable, artist, songs);
		media.add(a);
	}

	@Override
	public void setLimitedPlanLimit(int value) {
		Customer.setPlanLimit(value);

	}

	@Override
	public String getAllCustomersInfo() {
		String answer = "";

		Collections.sort(customers, Comparator.comparing(Customer::getName));

		answer += "***** Customers' Information *****";
		answer += "\n";

		for (int i = 0; i < customers.size(); i++) {
			answer += customers.get(i);
			answer += "\n";
		}

		return answer;
	}

	@Override
	public String getAllMediaInfo() {
		String answer = "";

		Collections.sort(media, Comparator.comparing(Media::getTitle));

		answer += "***** Media Information *****";
		answer += "\n";

		for (int i = 0; i < media.size(); i++) {
			answer += media.get(i);
			answer += "\n";
		}

		return answer;
	}

	@Override
	public boolean addToQueue(String customerName, String mediaTitle) {

		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getName() == customerName) {
				ArrayList<String> queue = customers.get(i).getQueue();
				for (int j = 0; j < queue.size(); j++) {
					if (queue.get(j) == mediaTitle) {
						return false;
					}
				}
				customers.get(i).addQueue(mediaTitle);
			}
		}
		return true;
	}

	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.getName() == customerName) {
				ArrayList<String> queue = c.getQueue();
				for (int j = 0; j < queue.size(); j++) {
					if (queue.get(j) == mediaTitle) {
						c.removeQueue(mediaTitle);
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String processRequests() {
		Collections.sort(customers, Comparator.comparing(Customer::getName));

		String answer = "";

		for (int i = 0; i < customers.size(); i++) {

			String planOfCustomer = customers.get(i).getPlan();
			for (int j = 0; j < customers.get(i).getQueue().size(); j++) {
				if (planOfCustomer == "LIMITED"
						&& customers.get(i).getRented().size() < customers.get(i).getPlanLimit()) {
					if (customers.get(i).getQueue().size() > 0) {
						String a = customers.get(i).getQueue().get(j);
						for (int k = 0; k < media.size(); k++) {
							String b = media.get(k).getTitle();
							int copies = media.get(k).getCopies();
							if (a == b && copies != 0) {
								customers.get(i).removeQueue(a);
								j--;
								customers.get(i).addRented(a);
								media.get(k).setCopies(copies - 1);
								answer += "Sending " + b + " to " + customers.get(i).getName() + "\n";
							}
						}
					}
				}
				else if (planOfCustomer == "UNLIMITED") {
					if (customers.get(i).getQueue().size() > 0) {
						String a = customers.get(i).getQueue().get(j);
						for (int k = 0; k < media.size(); k++) {
							String b = media.get(k).getTitle();
							int copies = media.get(k).getCopies();
							if (a == b && copies != 0) {
								customers.get(i).removeQueue(a);
								j--;
								customers.get(i).addRented(a);
								media.get(k).setCopies(copies - 1);
								answer += "Sending " + b + " to " + customers.get(i).getName() + "\n";
							}
						}
					}
				}
			}
		}
		return answer;
	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getName() == customerName) {
				for (int j = 0; j < media.size(); j++) {
					if (media.get(j).getTitle() == mediaTitle) {
						int copies = media.get(j).getCopies();
						media.get(j).setCopies(copies + 1);
						customers.get(i).removeRented(mediaTitle);
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {

		ArrayList<Media> specificTitles = new ArrayList<Media>(media);
		ArrayList<Media> temporary = new ArrayList<Media>();

		ArrayList<String> searchResults = new ArrayList<String>();

		if (title != null) {
			for (int i = 0; i < specificTitles.size(); i++) {
				if (title == specificTitles.get(i).getTitle()) {
					temporary.add(specificTitles.get(i));
				}
			}
			specificTitles = new ArrayList<Media>(temporary);
			temporary.clear();
		}

		if (rating != null) {
			for (int j = 0; j < specificTitles.size(); j++) {
				if (specificTitles.get(j) instanceof Movies) {
					Movies current = (Movies) specificTitles.get(j);
					if (rating == current.getRating()) {
						temporary.add(specificTitles.get(j));
					}
				}
			}
			specificTitles = new ArrayList<Media>(temporary);
			temporary.clear();
		}

		if (artist != null) {
			for (int k = 0; k < specificTitles.size(); k++) {
				if (specificTitles.get(k) instanceof Albums) {
					Albums current = (Albums) specificTitles.get(k);
					if (artist == current.getArtist()) {
						temporary.add(specificTitles.get(k));
					}
				}
			}
			specificTitles = new ArrayList<Media>(temporary);
			temporary.clear();
		}

		if (songs != null) {
			for (int l = 0; l < specificTitles.size(); l++) {
				if (specificTitles.get(l) instanceof Albums) {
					Albums current = (Albums) specificTitles.get(l);
					if (current.getSongs().contains(songs)) {
						temporary.add(specificTitles.get(l));
					}
				}
			}
			specificTitles = new ArrayList<Media>(temporary);
			temporary.clear();
		}

		for (int m = 0; m < specificTitles.size(); m++) {
			searchResults.add(specificTitles.get(m).getTitle());
		}

		Collections.sort(searchResults);

		return searchResults;
	}
}
