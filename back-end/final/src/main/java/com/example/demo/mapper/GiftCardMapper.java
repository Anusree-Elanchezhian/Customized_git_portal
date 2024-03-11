package com.example.demo.mapper;

import com.example.demo.dto.GiftCardDto;
import com.example.demo.entity.GiftCard;

public class GiftCardMapper {

    public static GiftCardDto mapToGiftCardDto(GiftCard giftCard) {
        GiftCardDto giftCardDto = new GiftCardDto();
        giftCardDto.setId(giftCard.getId());
        giftCardDto.setImageUrl(giftCard.getImageUrl());
        giftCardDto.setTitle(giftCard.getTitle());
        giftCardDto.setDescription(giftCard.getDescription());
        giftCardDto.setRating(giftCard.getRating());
        giftCardDto.setAvailability(giftCard.getAvailability());
        giftCardDto.setPrice(giftCard.getPrice());
        return giftCardDto;
    }

    public static GiftCard mapToGiftCard(GiftCardDto giftCardDto) {
        GiftCard giftCard = new GiftCard();
        giftCard.setId(giftCardDto.getId());
        giftCard.setImageUrl(giftCardDto.getImageUrl());
        giftCard.setTitle(giftCardDto.getTitle());
        giftCard.setDescription(giftCardDto.getDescription());
        giftCard.setRating(giftCardDto.getRating());
        giftCard.setAvailability(giftCardDto.getAvailability());
        giftCard.setPrice(giftCardDto.getPrice());
        return giftCard;
    }
}
