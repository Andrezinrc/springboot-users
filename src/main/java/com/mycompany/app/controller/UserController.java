package com.mycompany.app.controller;

import com.mycompany.app.model.User;
import com.mycompany.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Criar novo user
    @PostMapping
    public User createUser(@RequestParam String nome, @RequestParam String email) {
        return userService.createUser(nome, email);
    }

    //Listar todos os user
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Buscar user por ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // Atualizar user
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestParam String nome, @RequestParam String email) {
        boolean updated = userService.updateUser(id, nome, email);
        return updated ? "Usuário atualizado com sucesso." : "Usuário não encontrado.";
    }

    // Deletar user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? "Usuário deletado com sucesso." : "Usuário não encontrado.";
    }
}