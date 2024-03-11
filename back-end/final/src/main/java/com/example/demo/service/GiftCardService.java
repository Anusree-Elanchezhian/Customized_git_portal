package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GiftCardDto;

public interface GiftCardService {
    List<GiftCardDto> getAllGiftCards();

    GiftCardDto getGiftCardById(Long id);

    GiftCardDto createGiftCard(GiftCardDto giftCardDTO);

    GiftCardDto updateGiftCard(Long id, GiftCardDto giftCardDTO);

    void deleteGiftCard(Long id);
}
