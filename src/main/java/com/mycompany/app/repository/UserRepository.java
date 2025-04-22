package com.mycompany.app.repository;

import com.mycompany.app.model.User;
import org.springframework.data .jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{}
