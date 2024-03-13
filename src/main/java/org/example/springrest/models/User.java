package org.example.springrest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.springrest.validations.LoginForm;
import org.example.springrest.validations.RegisterForm;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;
    private String password;

    public User(RegisterForm registerForm) {
        this.id = null;
        this.name = registerForm.getName();
        this.email = registerForm.getEmail();
        this.password = registerForm.getPassword();
    }

    public User() {
        this.id = null;
        this.name = null;
        this.email = null;
        this.password = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean comparePassword(String password) {
        return Objects.equals(this.password, password);
    }
}
