package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "Jake", "Hough", "4075551234", "123 Main Street");
		
		service.addContact(contact);	}

	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "Jake", "Hough", "4075551234", "123 Main Street");
		
		service.addContact(contact);
		service.deleteContact("12345");
	}
	
	@Test
	void testUpdateContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "Jake", "Hough", "4075551234", "123 Main Street");
		
		service.addContact(contact);
		service.updateContact("12345", "Jacob", "Hough", "4075555678", "456 Main Street");
		
		assertEquals("Jacob", contact.getFirstName());
		assertEquals("Hough", contact.getLastName());
		assertEquals("4075555678", contact.getPhone());
		assertEquals("456 Main Street", contact.getAddress());
	}
	
	@Test
	void TestDuplicateContactId() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("12345", "Jake", "Hough", "4075551234", "123 Main Street");
		Contact contact2 = new Contact("12345", "John", "Smith", "4075555678", "456 Main Street");
		
		service.addContact(contact1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	
	@Test
	void testDeleteContactNoFound() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("99999");
		});
	}
	
	@Test
	void testUpdateContactNotFound() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("999999", "Jake", "Hough", "4075551234", "123 Main Street");
		});
	}
	
	
}
