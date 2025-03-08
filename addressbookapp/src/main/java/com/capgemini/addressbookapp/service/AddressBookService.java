package com.capgemini.addressbookapp.service;

import com.capgemini.addressbookapp.dto.AddressBookDTO;
import  com.capgemini.addressbookapp.model.AddressBook;
import com.capgemini.addressbookapp.repository.AddressBookRepository;
import com.capgemini.addressbookapp.validations.AddressBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    public AddressBook saveEntry(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook.setName(addressBookDTO.getName());
        addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBook.setEmail(addressBookDTO.getEmail());
        addressBook.setAddress(addressBookDTO.getAddress());
        addressBook.setCity(addressBookDTO.getCity());
        addressBook.setState(addressBookDTO.getState());
        addressBook.setZipcode(addressBookDTO.getZipcode());
        return repository.save(addressBook);
    }

    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    public AddressBook getEntryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book entry with ID " + id + " not found"));
    }

    public AddressBook updateAddressBook(Long id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = repository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book entry with ID " + id + " not found"));

        addressBook.setName(addressBookDTO.getName());
        addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBook.setEmail(addressBookDTO.getEmail());
        addressBook.setAddress(addressBookDTO.getAddress());
        addressBook.setCity(addressBookDTO.getCity());
        addressBook.setState(addressBookDTO.getState());
        addressBook.setZipcode(addressBookDTO.getZipcode());
        return repository.save(addressBook);
    }

    public void deleteEntry(Long id) {
        AddressBook addressBook = repository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book entry with ID " + id + " not found"));

        repository.delete(addressBook);
    }

    /*private final List<AddressBook> addressBookList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1); // To generate unique IDs

    public AddressBook saveEntry(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook();
        addressBook.setId(idCounter.getAndIncrement());
        addressBook.setName(addressBookDTO.getName());
        addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBook.setEmail(addressBookDTO.getEmail());
        addressBook.setAddress(addressBookDTO.getAddress());
        addressBookList.add(addressBook);
        return addressBook;
    }

    public List<AddressBook> getAllEntries() {
        return new ArrayList<>(addressBookList); // Return a copy to avoid external modifications
    }

    public AddressBook getEntryById(Long id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public AddressBook updateAddressBook(Long id, AddressBookDTO addressBookDTO) {
        Optional<AddressBook> existingEntry = addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();

        if (existingEntry.isPresent()) {
            AddressBook addressBook = existingEntry.get();
            addressBook.setName(addressBookDTO.getName());
            addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            addressBook.setEmail(addressBookDTO.getEmail());
            addressBook.setAddress(addressBookDTO.getAddress());
            return addressBook;
        } else {
            throw new RuntimeException("AddressBook entry with ID " + id + " not found");
        }
    }

    public void deleteEntry(Long id) {
        addressBookList.removeIf(entry -> entry.getId().equals(id));
    }*/
}