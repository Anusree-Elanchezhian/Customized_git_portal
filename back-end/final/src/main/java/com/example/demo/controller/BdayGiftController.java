package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.BdayGiftDto;
import com.example.demo.service.BdayGiftServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bday-gifts")
public class BdayGiftController {

    private BdayGiftServices bdayGiftService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<BdayGiftDto> createBdayGift(@RequestBody BdayGiftDto bdayGiftDto) {
        BdayGiftDto savedBdayGift = bdayGiftService.createBdayGift(bdayGiftDto);
        return new ResponseEntity<>(savedBdayGift, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BdayGiftDto> getBdayGiftById(@PathVariable("id") Long bdayGiftId) {
        BdayGiftDto bdayGiftDto = bdayGiftService.getBdayGiftById(bdayGiftId);
        return ResponseEntity.ok(bdayGiftDto);
    }

    @GetMapping
    public ResponseEntity<List<BdayGiftDto>> getAllBdayGifts() {
        List<BdayGiftDto> bdayGifts = bdayGiftService.getAllBdayGifts();
        return ResponseEntity.ok(bdayGifts);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<BdayGiftDto> updateBdayGift(@PathVariable("id") Long bdayGiftId,
            @RequestBody BdayGiftDto bdayGiftDto) {
        BdayGiftDto updatedBdayGift = bdayGiftService.updateBdayGift(bdayGiftId, bdayGiftDto);
        return ResponseEntity.ok(updatedBdayGift);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBdayGift(@PathVariable("id") Long bdayGiftId) {
        bdayGiftService.deleteBdayGift(bdayGiftId);
        return ResponseEntity.noContent().build();
    }
}
