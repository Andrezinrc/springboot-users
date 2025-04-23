package com.mycompany.app.controller;

import com.mycompany.app.security.JwtUtil;
import com.mycompany.app.model.User;
import com.mycompany.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserService userService;

    //login user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
       User user = userService.getUserByEmail(email);
       if(user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())){
          String token = jwtUtil.generateToken(email);
          return ResponseEntity.ok("Bearer " + token);
       }
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
    
    //Criar novo user
    @PostMapping
public User createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
       try {
          User user = userService.createUser(name, email, password);
          System.out.println("Usuário criado: " + user);
          return user;
       } catch (Exception err) {
          System.out.println("Houve um erro: " + err.getMessage());
          return null;
       }
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
    public String updateUser(@PathVariable int id, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        boolean updated = userService.updateUser(id, name, email, password);
        return updated ? "Usuário atualizado com sucesso." : "Usuário não encontrado.";
    }

    // Deletar user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? "Usuário deletado com sucesso." : "Usuário não encontrado.";
    }
}