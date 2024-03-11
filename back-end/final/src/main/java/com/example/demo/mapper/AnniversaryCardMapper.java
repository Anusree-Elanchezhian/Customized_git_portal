package com.example.demo.mapper;

import com.example.demo.dto.AnniversaryCardDto;
import com.example.demo.entity.AnniversaryCard;

public class AnniversaryCardMapper {

    public static AnniversaryCardDto mapToAnniversaryCardDto(AnniversaryCard anniversaryCard) {
        AnniversaryCardDto anniversaryCardDto = new AnniversaryCardDto();
        anniversaryCardDto.setId(anniversaryCard.getId());
        anniversaryCardDto.setImageUrl(anniversaryCard.getImageUrl());
        anniversaryCardDto.setTitle(anniversaryCard.getTitle());
        anniversaryCardDto.setDescription(anniversaryCard.getDescription());
        anniversaryCardDto.setRating(anniversaryCard.getRating());
        anniversaryCardDto.setAvailability(anniversaryCard.getAvailability());
        anniversaryCardDto.setPrice(anniversaryCard.getPrice());
        return anniversaryCardDto;
    }

    public static AnniversaryCard mapToAnniversaryCard(AnniversaryCardDto anniversaryCardDto) {
        AnniversaryCard anniversaryCard = new AnniversaryCard();
        anniversaryCard.setId(anniversaryCardDto.getId());
        anniversaryCard.setImageUrl(anniversaryCardDto.getImageUrl());
        anniversaryCard.setTitle(anniversaryCardDto.getTitle());
        anniversaryCard.setDescription(anniversaryCardDto.getDescription());
        anniversaryCard.setRating(anniversaryCardDto.getRating());
        anniversaryCard.setAvailability(anniversaryCardDto.getAvailability());
        anniversaryCard.setPrice(anniversaryCardDto.getPrice());
        return anniversaryCard;
    }
}
