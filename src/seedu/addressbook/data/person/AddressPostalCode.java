package seedu.addressbook.data.person;

public class AddressPostalCode {
	private final String value;
	
	private AddressPostalCode (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
