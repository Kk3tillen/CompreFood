package com.food.compreFoodAPI.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.food.compreFoodAPI.model.Food;
import com.food.compreFoodAPI.repository.FoodRepository;
import lombok.NonNull;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> listarTodos() {
        return foodRepository.findAll()
            .stream()
            .collect(Collectors.toList());
    }

    public Food cadastrarFood(@NonNull Food food) {
        return foodRepository.save(food);
    }

    public Food atualizarFood(@NonNull Long id, @NonNull Food food) {
        Food foodExistente = foodRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Comida não encontrada com id: " + id));

        foodExistente.setTitle(food.getTitle());
        foodExistente.setPrice(food.getPrice());
        foodExistente.setImage(food.getImage());

        return foodRepository.save(foodExistente);
    }

    public void deletarFood(@NonNull Long id) {
        if (!foodRepository.existsById(id)) {
            throw new RuntimeException("Comida não encontrada com id: " + id);
        }
        foodRepository.deleteById(id);
    }
}