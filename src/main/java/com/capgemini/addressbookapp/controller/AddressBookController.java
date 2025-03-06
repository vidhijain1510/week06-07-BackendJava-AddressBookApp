package com.capgemini.addressbookapp.controller;

import com.capgemini.addressbookapp.dto.AddressBookDTO;
import com.capgemini.addressbookapp.model.AddressBook;
import com.capgemini.addressbookapp.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;


    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        AddressBook addressBook = service.getEntryById(id);
        return (addressBook!=null)? ResponseEntity.ok(addressBook):ResponseEntity.notFound().build();

    }
    @PostMapping("/add")
    public ResponseEntity<AddressBook> addEntry(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook savedEntry = service.saveEntry(addressBookDTO);
        return ResponseEntity.ok(savedEntry);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @Valid @RequestBody AddressBookDTO newEntry) {
        AddressBook addressBook = service.updateAddressBook(id, newEntry);
        return (addressBook != null) ? ResponseEntity.ok(addressBook) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
        return ResponseEntity.ok().build();
    }
}
