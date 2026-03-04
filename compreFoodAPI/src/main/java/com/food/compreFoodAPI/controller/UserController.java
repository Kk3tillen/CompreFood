package com.food.compreFoodAPI.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.compreFoodAPI.dto.ClienteDTO;
import com.food.compreFoodAPI.dto.LoginDTO;
import com.food.compreFoodAPI.model.User;
import com.food.compreFoodAPI.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> fazerLogin(@RequestHeader("Authorization") String authHeader) {
        try {
            String base64 = authHeader.substring(6);
            String decoded = new String(Base64.getDecoder().decode(base64));
            String[] parts = decoded.split(":");
            String login = parts[0];
            String senha = parts[1];

            User user = userService.login(login, senha);

            ClienteDTO resposta = new ClienteDTO(user.getId(), user.getLogin());
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
