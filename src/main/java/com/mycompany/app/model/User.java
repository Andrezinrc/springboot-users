package com.mycompany.app.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
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

    //para debug mais facil
    @Override
    public String toString(){
        return "User{id= " + id + ", nome='" + name + "', email='" + email + "'}";
    }
}