package com.example.demo.service.impl;

import com.example.demo.dto.OccasionDto;
import com.example.demo.entity.Occasion;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.OccasionMapper;
import com.example.demo.repository.OccasionRepository;
import com.example.demo.service.OccasionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccasionServiceImpl implements OccasionService {

    private final OccasionRepository occasionRepository;

    public OccasionServiceImpl(OccasionRepository occasionRepository) {
        this.occasionRepository = occasionRepository;
    }

    @Override
    public OccasionDto createOccasion(OccasionDto occasionDto) {
        Occasion occasion = OccasionMapper.mapToOccasion(occasionDto);
        Occasion savedOccasion = occasionRepository.save(occasion);
        return OccasionMapper.mapToOccasionDto(savedOccasion);
    }

    @Override
    public OccasionDto getOccasionById(Long occasionId) {
        Occasion occasion = occasionRepository.findById(occasionId)
                .orElseThrow(() -> new ResourceNotFoundException("Occasion not found with id: " + occasionId));
        return OccasionMapper.mapToOccasionDto(occasion);
    }

    @Override
    public List<OccasionDto> getAllOccasions() {
        List<Occasion> occasions = occasionRepository.findAll();
        return occasions.stream().map(OccasionMapper::mapToOccasionDto).collect(Collectors.toList());
    }

    @Override
    public OccasionDto updateOccasion(Long occasionId, OccasionDto occasionDto) {
        Occasion existingOccasion = occasionRepository.findById(occasionId)
                .orElseThrow(() -> new ResourceNotFoundException("Occasion not found with id: " + occasionId));
        Occasion updatedOccasion = OccasionMapper.mapToOccasion(occasionDto);
        updatedOccasion.setId(existingOccasion.getId());
        Occasion savedOccasion = occasionRepository.save(updatedOccasion);
        return OccasionMapper.mapToOccasionDto(savedOccasion);
    }

    @Override
    public void deleteOccasion(Long occasionId) {
        occasionRepository.deleteById(occasionId);
    }
}
