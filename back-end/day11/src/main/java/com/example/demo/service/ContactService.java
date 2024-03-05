package com.example.demo.service;

import com.example.demo.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto createContact(ContactDto contactDto);

    ContactDto getContactById(Long contactId);

    List<ContactDto> getAllContacts();

    ContactDto updateContact(Long contactId, ContactDto contactDto);

    void deleteContact(Long contactId);
}
