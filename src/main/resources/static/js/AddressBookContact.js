class AddressBookContact {
    constructor(firstName, lastName, address, city, state, zip, phoneNumber, email) {
        this.firstName = this.validateName(firstName, "First Name");
        this.lastName = this.validateName(lastName, "Last Name");
        this.address = this.validateAddress(address);
        this.city = city;
        this.state = state;
        this.zip = this.validateZip(zip);
        this.phoneNumber = this.validatePhoneNumber(phoneNumber);
        this.email = this.validateEmail(email);
    }

    validateName(name, field) {
        if (!name || name.trim().length === 0) {
            throw new Error(`${field} cannot be empty`);
        }
        return name;
    }

    validateAddress(address) {
        if (!address || address.length < 5) {
            throw new Error("Address must be at least 5 characters long");
        }
        return address;
    }

    validateZip(zip) {
        const zipPattern = /^[0-9]{5,6}$/; // Zip code must be 5 or 6 digits
        if (!zipPattern.test(zip)) {
            throw new Error("Invalid Zip Code");
        }
        return zip;
    }

    validatePhoneNumber(phoneNumber) {
        const phonePattern = /^[0-9]{10}$/; // Must be a 10-digit number
        if (!phonePattern.test(phoneNumber)) {
            throw new Error("Invalid Phone Number");
        }
        return phoneNumber;
    }

    validateEmail(email) {
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailPattern.test(email)) {
            throw new Error("Invalid Email Address");
        }
        return email;
    }
}