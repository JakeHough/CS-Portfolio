package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContactCreation() {
		Contact contact = new Contact("12345", "Jake", "Hough", "4075551234", "123 Main Street");
			
			assertEquals("12345", contact.getContactId());
			assertEquals("Jake", contact.getFirstName());
			assertEquals("Hough", contact.getLastName());
			assertEquals("4075551234", contact.getPhone());
			assertEquals("123 Main Street", contact.getAddress());
	}

	@Test
	void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Jake", "Hough", "4075551234", "123 Main Street");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Christopher", "Hough", "4075551234", "123 Main Street");
		});
	}
	@Test
	void textLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Jake", "Houghingtons", "4075551234", "123 Main Street");
		});
	}
	@Test
	void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Jake", "Hough", "407555123", "123 Main Street");
		});
	}
	
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Jake", "Hough", "4075551234", "123 This Street Address Is Definitely Too Long");
		});
	}
	@Test
	void testNullFields() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact(null, "Jake", "Hough", "4075551234", "123 Main Street"));
		
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("12345", null, "Hough", "4075551234", "123 Main Street"));
		
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("12345", "Jake", null, "40755512345", "123 Main Street"));
		
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("12345", "Jake", "Hough", null, "123 Main Street"));
		
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("12345", "Jake", "Hough", "4075551234", null));
	}
	
	
}
