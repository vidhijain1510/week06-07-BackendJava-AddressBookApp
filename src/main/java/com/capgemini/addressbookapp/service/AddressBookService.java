package com.capgemini.addressbookapp.service;

import com.capgemini.addressbookapp.dto.AddressBookDTO;
import  com.capgemini.addressbookapp.model.AddressBook;
import com.capgemini.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    public AddressBook saveEntry(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        return repository.save(addressBook);
    }

    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    public AddressBook getEntryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AddressBook updateAddressBook(Long id, AddressBookDTO addressBookDTO) {
        Optional<AddressBook> existingEntry = repository.findById(id);

        if (existingEntry.isPresent()) {
            AddressBook addressBook = existingEntry.get();
            addressBook.setName(addressBookDTO.getName());
            addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            addressBook.setEmail(addressBookDTO.getEmail());
            addressBook.setAddress(addressBookDTO.getAddress());
            return repository.save(addressBook);
        } else {
            throw new RuntimeException("AddressBook entry with ID " + id + " not found");
        }
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}