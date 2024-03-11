package com.example.demo.mapper;

import com.example.demo.dto.BdayGiftDto;
import com.example.demo.entity.BdayGift;

public class BdayGiftMapper {

    public static BdayGiftDto mapToBdayGiftDto(BdayGift bdayGift) {
        return new BdayGiftDto(
                bdayGift.getId(),
                bdayGift.getName(),
                bdayGift.getMinimumQuantity(),
                bdayGift.getPrice(),
                bdayGift.getStock());
    }

    public static BdayGift mapToBdayGift(BdayGiftDto bdayGiftDto) {
        BdayGift bdayGift = new BdayGift();
        bdayGift.setId(bdayGiftDto.getId());
        bdayGift.setName(bdayGiftDto.getName());
        bdayGift.setMinimumQuantity(bdayGiftDto.getMinimumQuantity());
        bdayGift.setPrice(bdayGiftDto.getPrice());
        bdayGift.setStock(bdayGiftDto.getStock());
        return bdayGift;
    }
}
