package com.food.compreFoodAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.food.compreFoodAPI.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

}