package com.food.compreFoodAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.compreFoodAPI.model.User;
import com.food.compreFoodAPI.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String login, String senha) {

        User user = userRepository
                .findByLogin(login)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado" + login));

        if (!user.getSenha().equals(senha)) {
            throw new RuntimeException("Senha inválida");
        }

        return user;
    }
}