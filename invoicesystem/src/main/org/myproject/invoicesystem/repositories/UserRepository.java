package org.myproject.invoicesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.myproject.invoicesystem.entities.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
