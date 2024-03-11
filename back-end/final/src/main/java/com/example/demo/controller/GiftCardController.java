package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.GiftCardDto;
import com.example.demo.service.GiftCardService;

import java.util.List;

@RestController
@RequestMapping("/api/giftcards")
@CrossOrigin(origins = "*")
public class GiftCardController {

    @Autowired
    private GiftCardService giftCardService;

    @GetMapping
    public ResponseEntity<List<GiftCardDto>> getAllGiftCards() {
        List<GiftCardDto> giftCards = giftCardService.getAllGiftCards();
        return new ResponseEntity<>(giftCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiftCardDto> getGiftCardById(@PathVariable Long id) {
        GiftCardDto giftCard = giftCardService.getGiftCardById(id);
        if (giftCard != null) {
            return new ResponseEntity<>(giftCard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<GiftCardDto> createGiftCard(@RequestBody GiftCardDto giftCardDTO) {
        GiftCardDto createdGiftCard = giftCardService.createGiftCard(giftCardDTO);
        return new ResponseEntity<>(createdGiftCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiftCardDto> updateGiftCard(@PathVariable Long id, @RequestBody GiftCardDto giftCardDTO) {
        GiftCardDto updatedGiftCard = giftCardService.updateGiftCard(id, giftCardDTO);
        return new ResponseEntity<>(updatedGiftCard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiftCard(@PathVariable Long id) {
        giftCardService.deleteGiftCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
