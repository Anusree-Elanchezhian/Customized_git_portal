package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BdayGiftDto;

public interface BdayGiftServices {
    BdayGiftDto createBdayGift(BdayGiftDto bdayGiftDto);

    BdayGiftDto getBdayGiftById(Long bdayGiftId);

    List<BdayGiftDto> getAllBdayGifts();

    BdayGiftDto updateBdayGift(Long bdayGiftId, BdayGiftDto bdayGiftDto);

    void deleteBdayGift(Long bdayGiftId);
}
