package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BdayGiftDto {
    private Long id;
    private String name;
    private int minimumQuantity;
    private double price;
    private int stock;

}
