package com.example.demo.service.impl;

import com.example.demo.dto.GiftCardDto;
import com.example.demo.entity.GiftCard;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.GiftCardMapper;
import com.example.demo.repository.GiftCardRepository;
import com.example.demo.service.GiftCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftCardServiceImpl implements GiftCardService {

    private final GiftCardRepository giftCardRepository;

    public GiftCardServiceImpl(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
    }

    @Override
    public GiftCardDto createGiftCard(GiftCardDto giftCardDto) {
        GiftCard giftCard = GiftCardMapper.mapToGiftCard(giftCardDto);
        GiftCard savedGiftCard = giftCardRepository.save(giftCard);
        return GiftCardMapper.mapToGiftCardDto(savedGiftCard);
    }

    @Override
    public GiftCardDto getGiftCardById(Long giftCardId) {
        GiftCard giftCard = giftCardRepository.findById(giftCardId)
                .orElseThrow(() -> new ResourceNotFoundException("GiftCard not found with id: " + giftCardId));
        return GiftCardMapper.mapToGiftCardDto(giftCard);
    }

    @Override
    public List<GiftCardDto> getAllGiftCards() {
        List<GiftCard> giftCards = giftCardRepository.findAll();
        return giftCards.stream().map(GiftCardMapper::mapToGiftCardDto).collect(Collectors.toList());
    }

    @Override
    public GiftCardDto updateGiftCard(Long giftCardId, GiftCardDto giftCardDto) {
        GiftCard existingGiftCard = giftCardRepository.findById(giftCardId)
                .orElseThrow(() -> new ResourceNotFoundException("GiftCard not found with id: " + giftCardId));
        GiftCard updatedGiftCard = GiftCardMapper.mapToGiftCard(giftCardDto);
        updatedGiftCard.setId(existingGiftCard.getId());
        GiftCard savedGiftCard = giftCardRepository.save(updatedGiftCard);
        return GiftCardMapper.mapToGiftCardDto(savedGiftCard);
    }

    @Override
    public void deleteGiftCard(Long giftCardId) {
        giftCardRepository.deleteById(giftCardId);
    }
}
