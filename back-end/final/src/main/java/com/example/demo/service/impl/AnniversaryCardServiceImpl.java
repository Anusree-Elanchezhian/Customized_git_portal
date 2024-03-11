package com.example.demo.service.impl;

import com.example.demo.dto.AnniversaryCardDto;
import com.example.demo.entity.AnniversaryCard;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.AnniversaryCardMapper;
import com.example.demo.repository.AnniversaryCardRepository;
import com.example.demo.service.AnniversaryCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnniversaryCardServiceImpl implements AnniversaryCardService {

    private final AnniversaryCardRepository anniversaryCardRepository;

    public AnniversaryCardServiceImpl(AnniversaryCardRepository anniversaryCardRepository) {
        this.anniversaryCardRepository = anniversaryCardRepository;
    }

    @Override
    public AnniversaryCardDto createAnniversaryCard(AnniversaryCardDto anniversaryCardDto) {
        AnniversaryCard anniversaryCard = AnniversaryCardMapper.mapToAnniversaryCard(anniversaryCardDto);
        AnniversaryCard savedAnniversaryCard = anniversaryCardRepository.save(anniversaryCard);
        return AnniversaryCardMapper.mapToAnniversaryCardDto(savedAnniversaryCard);
    }

    @Override
    public AnniversaryCardDto getAnniversaryCardById(Long anniversaryCardId) {
        AnniversaryCard anniversaryCard = anniversaryCardRepository.findById(anniversaryCardId)
                .orElseThrow(() -> new ResourceNotFoundException("AnniversaryCard not found with id: " + anniversaryCardId));
        return AnniversaryCardMapper.mapToAnniversaryCardDto(anniversaryCard);
    }

    @Override
    public List<AnniversaryCardDto> getAllAnniversaryCards() {
        List<AnniversaryCard> anniversaryCards = anniversaryCardRepository.findAll();
        return anniversaryCards.stream().map(AnniversaryCardMapper::mapToAnniversaryCardDto).collect(Collectors.toList());
    }

    @Override
    public AnniversaryCardDto updateAnniversaryCard(Long anniversaryCardId, AnniversaryCardDto anniversaryCardDto) {
        AnniversaryCard existingAnniversaryCard = anniversaryCardRepository.findById(anniversaryCardId)
                .orElseThrow(() -> new ResourceNotFoundException("AnniversaryCard not found with id: " + anniversaryCardId));
        AnniversaryCard updatedAnniversaryCard = AnniversaryCardMapper.mapToAnniversaryCard(anniversaryCardDto);
        updatedAnniversaryCard.setId(existingAnniversaryCard.getId());
        AnniversaryCard savedAnniversaryCard = anniversaryCardRepository.save(updatedAnniversaryCard);
        return AnniversaryCardMapper.mapToAnniversaryCardDto(savedAnniversaryCard);
    }

    @Override
    public void deleteAnniversaryCard(Long anniversaryCardId) {
        anniversaryCardRepository.deleteById(anniversaryCardId);
    }
}
