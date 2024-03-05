package com.example.demo.mapper;

import com.example.demo.dto.ContactDto;
import com.example.demo.entity.Contact;

public class ContactMapper {

    public static ContactDto mapToContactDto(Contact contact) {
        return new ContactDto(
                contact.getName(),
                contact.getEmail(),
                contact.getMessage());
    }

    public static Contact mapToContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setMessage(contactDto.getMessage());
        return contact;
    }
}
