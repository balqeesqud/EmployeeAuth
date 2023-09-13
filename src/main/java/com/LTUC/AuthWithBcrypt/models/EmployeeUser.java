package com.LTUC.AuthWithBcrypt.models;

import com.LTUC.AuthWithBcrypt.repositories.EmployeeJpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;


    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<UserPosts>posts;

    public EmployeeUser() {
    }

    public EmployeeUser(String username, String hashedPassword) {
        this.username = username;
        this.password = hashedPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String hashedPassword) {
        this.password = hashedPassword;
    }

    @Override
    public String toString() {
        return "EmployeeUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
