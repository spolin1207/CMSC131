package sysutilities;

public class Name {
	private String firstName, middleName, lastName, nickName;
	private char separator;
	private static int nameObjsCount = 0;
	
	
	public Name() {
		this.firstName = "NOFIRSTNAME";
		this.middleName = "NOMIDDLENAME";
		this.lastName = "NOLASTNAME";
		
		this.separator = '#';
		nameObjsCount++;
	}
	
	private boolean validSeparator(char separator) {
		if (separator == '#' || separator == ',' || separator == '-') {
			return true;
		} else {
			return false;
		}
	}
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.middleName = "";
		this.lastName = lastName;
		
		this.separator = ',';
		nameObjsCount++;
	}
	
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
		this.separator = ',';
		nameObjsCount++;
	}
	
	public Name(String firstName, String middleName, String lastName, char separator) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
		if (validSeparator(separator) == true) {
			this.separator = separator;
		} else {
			this.separator = ',';
		}
		nameObjsCount++;
	}
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} 
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Name test = (Name) obj;
		
		if (this.firstName == test.firstName && this.middleName == test.middleName && this.lastName == test.lastName) {
			return true;
		} else {
			return false;
		}
	}
	
	public int compareTo(Name n) {
		int val1, val2, val3;
		
		val1 = this.lastName.compareTo(n.lastName);
		if (val1 == 0) {
			return val1;
		}
		val2 = this.firstName.compareTo(n.firstName);
		if (val2 == 0) {
			return val2;
		}
		val3 = this.middleName.compareTo(n.middleName);
		return val3;
	}
	
	public static int getNumberOfNameObjects() {
		return nameObjsCount;
	}
	
	public static Name normalize(Name obj, boolean caseNow) {
		String newL;
		String newF;
		String newM;
		
		if (caseNow == false) {
			newL = obj.lastName.toLowerCase();
			newF = obj.firstName.toLowerCase();
			newM = obj.middleName.toLowerCase();
		} else {
			newL = obj.lastName.toUpperCase();
			newF = obj.firstName.toUpperCase();
			newM = obj.middleName.toUpperCase();
		}
		Name nextName = new Name(newF, newM, newL);
		return nextName;
	}
	
	public String toString() {
		String print = "";
		if ((this.middleName == "") && (this.nickName == null)) {
			print += this.lastName + separator + this.firstName;
		} else if ((this.middleName != "") && (this.nickName == null)) {
			print += this.lastName + separator + this.firstName + separator + this.middleName;
		} else {
			print += this.lastName + separator + this.firstName + separator + this.middleName + "(" + this.nickName + ")";
		}
		return print;
	}
// Getters and Setters	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getNickname() {
		if (nickName.equals("")) {
			return "";
		} else {
			return nickName;
		}

	}
	
	public void setNickname(String nickName) {
		this.nickName = nickName;
	}
	
	public char getSeparator() {
		return separator;
	}
	
	public void setSeparator(char separator) {
		if (validSeparator(separator) == true) {
			this.separator = separator;
		} else {
			this.separator = separator;
		}
	}
	

}

