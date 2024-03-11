package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AnniversaryCardDto;
import com.example.demo.service.AnniversaryCardService;

import java.util.List;

@RestController
@RequestMapping("/api/anniversarycards")
@CrossOrigin(origins = "*")
public class AnniversaryCardController {

    @Autowired
    private AnniversaryCardService anniversaryCardService;

    @GetMapping
    public ResponseEntity<List<AnniversaryCardDto>> getAllAnniversaryCards() {
        List<AnniversaryCardDto> anniversaryCards = anniversaryCardService.getAllAnniversaryCards();
        return new ResponseEntity<>(anniversaryCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnniversaryCardDto> getAnniversaryCardById(@PathVariable Long id) {
        AnniversaryCardDto anniversaryCard = anniversaryCardService.getAnniversaryCardById(id);
        if (anniversaryCard != null) {
            return new ResponseEntity<>(anniversaryCard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AnniversaryCardDto> createAnniversaryCard(
            @RequestBody AnniversaryCardDto anniversaryCardDto) {
        AnniversaryCardDto createdAnniversaryCard = anniversaryCardService.createAnniversaryCard(anniversaryCardDto);
        return new ResponseEntity<>(createdAnniversaryCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnniversaryCardDto> updateAnniversaryCard(@PathVariable Long id,
            @RequestBody AnniversaryCardDto anniversaryCardDto) {
        AnniversaryCardDto updatedAnniversaryCard = anniversaryCardService.updateAnniversaryCard(id,
                anniversaryCardDto);
        return new ResponseEntity<>(updatedAnniversaryCard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnniversaryCard(@PathVariable Long id) {
        anniversaryCardService.deleteAnniversaryCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
