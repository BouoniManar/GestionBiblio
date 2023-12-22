package com.simpleform.repository;

import com.simpleform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByLoginAndPassword(String login, String password);
    Optional <Users> findFirstByLogin(String login);
}
