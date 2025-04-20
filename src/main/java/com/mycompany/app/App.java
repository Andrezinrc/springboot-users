package com.mycompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mycompany.app.service.UserService;
import com.mycompany.app.model.User;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Server rodando!\n");

        //teste direto
        UserService userService = new UserService();

        userService.createUser("teste1", "teste1@email.com");
        userService.createUser("teste2", "teste2@email.com");
        userService.createUser("teste3", "teste3@email.com");

        System.out.println("Todos os usuários:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("\nUsuário com ID 2:");
        System.out.println(userService.getUserById(2));

        System.out.println("\nAtualizando usuário ID 2:");
        boolean updated = userService.updateUser(2, "teste6", "teste6@email.com");
        System.out.println(updated ? "Atualizado com sucesso" : "Usuário não encontrado");

        System.out.println("\nLista atualizada:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("\nDeletando usuário ID 1:");
        boolean deleted = userService.deleteUser(1);
        System.out.println(deleted ? "Deletado com sucesso" : "Usuário não encontrado");

        System.out.println("\nLista final:");
        userService.getAllUsers().forEach(System.out::println);
    }
}