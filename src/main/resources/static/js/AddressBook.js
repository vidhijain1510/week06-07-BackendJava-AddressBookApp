class AddressBook {
    constructor() {
        this.contacts = [];
    }

    addContact(contact) {
        this.contacts.push(contact);
        console.log("Contact added successfully:", contact);
    }

    getAllContacts() {
        return this.contacts;
    }
}

// Usage Example
try {
    const addressBook = new AddressBook();

    const contact1 = new AddressBookContact(
        "John",
        "Doe",
        "123 Main St",
        "New York",
        "NY",
        "10001",
        "9876543210",
        "john.doe@example.com"
    );

    addressBook.addContact(contact1);
    console.log("All Contacts:", addressBook.getAllContacts());
} catch (error) {
    console.error(error.message);
}