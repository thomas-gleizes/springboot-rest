package org.example.springrest.validations;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class RegisterForm {

    @Min(3)
    @Max(64)
    private String name;

    @NotBlank
    @Max(64)
    private String email;

    @Min(6)
    @Max(32)
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
