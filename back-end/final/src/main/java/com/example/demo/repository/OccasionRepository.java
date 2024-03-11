package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Occasion;

public interface OccasionRepository extends JpaRepository<Occasion, Long> {
}
