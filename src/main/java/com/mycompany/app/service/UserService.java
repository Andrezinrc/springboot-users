package com.mycompany.app.service;

import com.mycompany.app.model.User;
import com.mycompany.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //cria user
    public User createUser(String name, String email,String password) {
        
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email ja cadastrado!");
        }
        
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.encryptPassword(password);
        return userRepository.save(user);
    }

    // busca todos os users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // busca user pelo id
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    // busca user pelo email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    // atualiza user
    public boolean updateUser(int id, String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){

            if(userRepository.existsByEmail(email)){
              throw new RuntimeException("Email ja cadastrado!");
            }
            
            User user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            user.encryptPassword(password);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    // deleta user pelo id
    public boolean deleteUser(int id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}