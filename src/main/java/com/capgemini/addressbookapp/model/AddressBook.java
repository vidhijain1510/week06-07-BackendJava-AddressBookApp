package com.capgemini.addressbookapp.model;

import      com.capgemini.addressbookapp.dto.AddressBookDTO;
import jakarta.persistence.*;


@Entity
@Table(name="ADDRESSBOOK")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public AddressBook() {
    }

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.email = addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
