package com.food.compreFoodAPI.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.food.compreFoodAPI.model.Food;
import com.food.compreFoodAPI.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/get")
    public ResponseEntity<List<Food>> ListFoods() {
        List<Food> foods = foodService.listarTodos();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Food> cadastrarComida(@RequestBody Food food) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(">>> Usuário autenticado: " + auth.getName());
        System.out.println(">>> Está autenticado: " + auth.isAuthenticated());
        System.out.println(">>> Authorities: " + auth.getAuthorities());
        try {
            Food comidaCadastrada = foodService.cadastrarFood(food);
            if (comidaCadastrada == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(comidaCadastrada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Food> atualizarComida(@PathVariable Long id, @RequestBody Food food) {
        try {
            Food comidaAtualizada = foodService.atualizarFood(id, food);
            if (comidaAtualizada == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(comidaAtualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarComida(@PathVariable Long id) {
        try {
            foodService.deletarFood(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}