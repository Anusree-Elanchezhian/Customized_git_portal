package com.example.demo.service.impl;

import com.example.demo.dto.ContactDto;
import com.example.demo.entity.Contact;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ContactMapper;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact = ContactMapper.mapToContact(contactDto);
        Contact savedContact = contactRepository.save(contact);
        return ContactMapper.mapToContactDto(savedContact);
    }

    @Override
    public ContactDto getContactById(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + contactId));
        return ContactMapper.mapToContactDto(contact);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(ContactMapper::mapToContactDto).collect(Collectors.toList());
    }

    @Override
    public ContactDto updateContact(Long contactId, ContactDto contactDto) {
        Contact existingContact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + contactId));
        Contact updatedContact = ContactMapper.mapToContact(contactDto);
        updatedContact.setId(existingContact.getId());
        Contact savedContact = contactRepository.save(updatedContact);
        return ContactMapper.mapToContactDto(savedContact);
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }
}
