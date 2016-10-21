package com.example.repository;

import com.example.domain.FoodPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodPriceRepository extends JpaRepository<FoodPrice, Integer> {

}
