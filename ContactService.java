import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contactMap;

    public ContactService() {
        contactMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contactMap.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contactMap.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }

        Contact contact = contactMap.get(contactId);
        
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    public Contact getContact(String contactId) {
        return contactMap.get(contactId);
    }
}
