package seedu.addressbook.data.person;

public class AddressStreet {
	private final String value;
	
	private AddressStreet (String value) {
		this.value = value;
	}
	
	public String getValue () {
		return this.value;
	}
}
