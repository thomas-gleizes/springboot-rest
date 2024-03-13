package org.example.springrest.repositories;

import org.example.springrest.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>{

    public User findByEmail(String email);
}
