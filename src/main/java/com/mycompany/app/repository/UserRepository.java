package com.mycompany.app.repository;

import java.util.Optional;
import com.mycompany.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio responsavel pelas operacoes de acesso a dados da entidade User

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}