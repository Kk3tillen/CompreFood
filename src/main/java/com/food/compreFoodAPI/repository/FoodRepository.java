package com.food.compreFoodAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.compreFoodAPI.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
