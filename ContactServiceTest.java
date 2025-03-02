import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact1);

        Contact contact2 = new Contact("1234567890", "Jane", "Doe", "0987654321", "456 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("1234567890");
        });
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");

        service.addContact(contact);
        service.updateContact("1234567890", "Johnathan", "Doe", "9876543210", "456 Main Street");

        Contact updatedContact = service.getContact("1234567890");
        assertEquals("Johnathan", updatedContact.getFirstName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Main Street", updatedContact.getAddress());
    }
}
