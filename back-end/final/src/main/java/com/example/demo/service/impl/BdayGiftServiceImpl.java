package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BdayGiftDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.BdayGiftMapper;
import com.example.demo.entity.BdayGift;
import com.example.demo.repository.BdayGiftRepository;
import com.example.demo.service.BdayGiftServices;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BdayGiftServiceImpl implements BdayGiftServices {

    private final BdayGiftRepository bdayGiftRepository;

    @Override
    public BdayGiftDto createBdayGift(BdayGiftDto bdayGiftDto) {
        BdayGift bdayGift = BdayGiftMapper.mapToBdayGift(bdayGiftDto);
        BdayGift savedBdayGift = bdayGiftRepository.save(bdayGift);
        return BdayGiftMapper.mapToBdayGiftDto(savedBdayGift);
    }

    @Override
    public BdayGiftDto getBdayGiftById(Long bdayGiftId) {
        BdayGift bdayGift = bdayGiftRepository.findById(bdayGiftId)
                .orElseThrow(() -> new ResourceNotFoundException("BdayGift not found with id: " + bdayGiftId));
        return BdayGiftMapper.mapToBdayGiftDto(bdayGift);
    }

    @Override
    public List<BdayGiftDto> getAllBdayGifts() {
        List<BdayGift> bdayGifts = bdayGiftRepository.findAll();
        return bdayGifts.stream().map(BdayGiftMapper::mapToBdayGiftDto).collect(Collectors.toList());
    }

    @Override
    public BdayGiftDto updateBdayGift(Long bdayGiftId, BdayGiftDto bdayGiftDto) {
        BdayGift existingBdayGift = bdayGiftRepository.findById(bdayGiftId)
                .orElseThrow(() -> new ResourceNotFoundException("BdayGift not found with id: " + bdayGiftId));
        BdayGift updatedBdayGift = BdayGiftMapper.mapToBdayGift(bdayGiftDto);
        updatedBdayGift.setId(existingBdayGift.getId());
        BdayGift savedBdayGift = bdayGiftRepository.save(updatedBdayGift);
        return BdayGiftMapper.mapToBdayGiftDto(savedBdayGift);
    }

    @Override
    public void deleteBdayGift(Long bdayGiftId) {
        bdayGiftRepository.deleteById(bdayGiftId);
    }
}
