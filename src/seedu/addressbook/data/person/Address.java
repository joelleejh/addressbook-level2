package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "123, some street";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in this order: "
															 + "BLOCK, STREET, UNIT, POSTAL_CODE";
	public static final String ADDRESS_VALIDATION_REGEX = ".+";

	public final String value;
	private boolean isPrivate;

	private AddressBlock block;
	private AddressStreet street;
	private AddressUnit unit;
	private AddressPostalCode postalCode;
	
	/**
	 * Validates given address.
	 *
	 * @throws IllegalValueException
	 *             if given address string is invalid.
	 */
	public Address(String address, boolean isPrivate) throws IllegalValueException {
		String trimmedAddress = address.trim();
		this.isPrivate = isPrivate;
		String[] addressPieces = trimmedAddress.split(",");
		if (!isValidAddress(addressPieces)) {
			throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
		}
		
		this.block = new AddressBlock(addressPieces[0].trim());
		this.street = new AddressStreet(addressPieces[1].trim());
		this.unit = new AddressUnit(addressPieces[2].trim());
		this.postalCode = new AddressPostalCode(addressPieces[3].trim());
		
		this.value = trimmedAddress;
	}

	/**
	 * Returns true if a given string is a valid person email.
	 */
	public static boolean isValidAddress(String test) {
		return test.matches(ADDRESS_VALIDATION_REGEX);
	}
	
	public String getAddressBlock () {
		return block.getValue();
	}
	
	public String getStreet() {
		return street.getValue();
	}
	
	public String getUnit() {
		return unit.getValue();
	}

	public String getPostalCode() {
		return postalCode.getValue();
	}
	
	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Address // instanceof handles nulls
						&& this.value.equals(((Address) other).value)); // state
																		// check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
