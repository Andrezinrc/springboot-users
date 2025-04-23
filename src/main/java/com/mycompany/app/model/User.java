package com.mycompany.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;

    public User(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {}

    //getters e setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    //Metodo para encriptar a senha
    public void encryptPassword(String rawPassword) {
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       this.password = encoder.encode(rawPassword);
    }

    //para debug mais facil
    @Override
    public String toString(){
        return "User{id= " + id + ", nome='" + name + "', email='" + email + "', password='" + password + "'}";
    }
}