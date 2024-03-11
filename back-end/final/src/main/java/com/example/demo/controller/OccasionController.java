package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.OccasionDto;
import com.example.demo.service.OccasionService;

import java.util.List;

@RestController
@RequestMapping("/api/occasions")
@CrossOrigin(origins = "*")
public class OccasionController {

    @Autowired
    private OccasionService occasionService;

    @GetMapping
    public ResponseEntity<List<OccasionDto>> getAllOccasions() {
        List<OccasionDto> occasions = occasionService.getAllOccasions();
        return new ResponseEntity<>(occasions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccasionDto> getOccasionById(@PathVariable Long id) {
        OccasionDto occasion = occasionService.getOccasionById(id);
        if (occasion != null) {
            return new ResponseEntity<>(occasion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OccasionDto> createOccasion(@RequestBody OccasionDto occasionDTO) {
        OccasionDto createdOccasion = occasionService.createOccasion(occasionDTO);
        return new ResponseEntity<>(createdOccasion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OccasionDto> updateOccasion(@PathVariable Long id, @RequestBody OccasionDto occasionDTO) {
        OccasionDto updatedOccasion = occasionService.updateOccasion(id, occasionDTO);
        return new ResponseEntity<>(updatedOccasion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOccasion(@PathVariable Long id) {
        occasionService.deleteOccasion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
