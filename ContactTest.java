import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }
}
@Test
public void testInvalidPhoneNumber() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("1234567890", "John", "Doe", "12345", "123 Main Street");
    });
}

@Test
public void testInvalidAddress() {
    assertThrows(IllegalArgumentException.class, () -> {
        new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street, Apt 456, City, State, 78910");
    });
}
}