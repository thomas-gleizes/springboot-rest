package org.example.springrest.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class RegisterForm {

    @Min(3)
    @Max(64)
    private String name;

    @Email
    @Max(64)
    private String email;

    @Min(6)
    @Max(32)
    private String password;
}
