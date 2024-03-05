package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BdayGift;

@Repository
public interface BdayGiftRepository extends JpaRepository<BdayGift, Long> {
}
