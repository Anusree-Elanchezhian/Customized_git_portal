package com.example.demo.controller;

import com.example.demo.dto.ContactDto;
import com.example.demo.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto) {
        ContactDto savedContact = contactService.createContact(contactDto);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable("id") Long contactId) {
        ContactDto contactDto = contactService.getContactById(contactId);
        return ResponseEntity.ok(contactDto);
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<ContactDto> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable("id") Long contactId,
            @RequestBody ContactDto contactDto) {
        ContactDto updatedContact = contactService.updateContact(contactId, contactDto);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") Long contactId) {
        contactService.deleteContact(contactId);
        return ResponseEntity.noContent().build();
    }
}
