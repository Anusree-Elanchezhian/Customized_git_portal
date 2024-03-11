package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OccasionDto {
    private Long id;
    private String imageUrl;
    private String title;
    private String description;
    private double rating;
    private String availability;
    private int price; // Same field as GiftCardDto

    // Getters and setters
}
