package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AnniversaryCardDto;

public interface AnniversaryCardService {
    List<AnniversaryCardDto> getAllAnniversaryCards();

    AnniversaryCardDto getAnniversaryCardById(Long id);

    AnniversaryCardDto createAnniversaryCard(AnniversaryCardDto anniversaryCardDTO);

    AnniversaryCardDto updateAnniversaryCard(Long id, AnniversaryCardDto anniversaryCardDTO);

    void deleteAnniversaryCard(Long id);
}
