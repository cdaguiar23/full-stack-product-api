package com.productmanager.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productmanager.produto.dto.UserDTO;
import com.productmanager.produto.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> listarTodos() {
        List<UserDTO> users = userService.listarTodos();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registrarUsuario(@Valid @RequestBody UserDTO userDTO) {
        UserDTO user = userService.criarUsuario(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
