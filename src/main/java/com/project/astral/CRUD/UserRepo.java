package com.project.astral.CRUD;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Component
@Transactional(readOnly = true) 
public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByName(String name);
}
