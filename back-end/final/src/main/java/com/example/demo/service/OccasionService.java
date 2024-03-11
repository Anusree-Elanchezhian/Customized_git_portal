package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OccasionDto;

public interface OccasionService {
    List<OccasionDto> getAllOccasions();

    OccasionDto getOccasionById(Long id);

    OccasionDto createOccasion(OccasionDto occasionDTO);

    OccasionDto updateOccasion(Long id, OccasionDto occasionDTO);

    void deleteOccasion(Long id);
}
