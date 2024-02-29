package com.example.adp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private String name;
    private int rating;
    private String comment;
    private Long userId;

    // Constructors, getters, and setters
}
