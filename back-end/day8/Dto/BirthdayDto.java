package com.example.adp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BirthdayDto {
    private Long id;
    private String name;
    private String category;
    private double price;
    private String imgUrl;
    private boolean available;

    // Constructors, getters, and setters
}
