package seedu.addressbook.data.tag;

import java.util.List;

import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;

public class Tagging {

	private	final boolean isAdded;
	private final Person person; 
	private final Tag tag;
	
	public Tagging (boolean isAdded, Person person, Tag tag) {
		this.isAdded = isAdded;
		this.person = person;
		this.tag = tag;
	}
	
	public Name getName() {
		return person.getName();
	}
	
	public Tag getTag() {
		return tag;
	}
	
	public String printTagging() {
		String sign;
		if (isAdded) {
			sign = "+";
		} else {
			sign = "-";
		}
		return sign + " " + getName() + " " + tag.toString();
	}
	
	public static void printAllTaggings(List<Tagging> taggingList) {
		for (Tagging taggingList1 : taggingList) {
				taggingList1.printTagging();
		}
	}
}
