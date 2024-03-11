package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GiftCard;

public interface GiftCardRepository extends JpaRepository<GiftCard, Long> {
}
