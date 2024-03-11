package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AnniversaryCard;

public interface AnniversaryCardRepository extends JpaRepository<AnniversaryCard, Long> {
}
