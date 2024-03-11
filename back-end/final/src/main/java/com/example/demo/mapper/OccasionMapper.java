package com.example.demo.mapper;

import com.example.demo.dto.OccasionDto;
import com.example.demo.entity.Occasion;

public class OccasionMapper {

    public static OccasionDto mapToOccasionDto(Occasion occasion) {
        OccasionDto occasionDto = new OccasionDto();
        occasionDto.setId(occasion.getId());
        occasionDto.setImageUrl(occasion.getImageUrl());
        occasionDto.setTitle(occasion.getTitle());
        occasionDto.setDescription(occasion.getDescription());
        occasionDto.setRating(occasion.getRating());
        occasionDto.setAvailability(occasion.getAvailability());
        occasionDto.setPrice(occasion.getPrice());
        return occasionDto;
    }

    public static Occasion mapToOccasion(OccasionDto occasionDto) {
        Occasion occasion = new Occasion();
        occasion.setId(occasionDto.getId());
        occasion.setImageUrl(occasionDto.getImageUrl());
        occasion.setTitle(occasionDto.getTitle());
        occasion.setDescription(occasionDto.getDescription());
        occasion.setRating(occasionDto.getRating());
        occasion.setAvailability(occasionDto.getAvailability());
        occasion.setPrice(occasionDto.getPrice());
        return occasion;
    }
}
