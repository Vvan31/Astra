package com.project.astral.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.astral.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByUserName(String userName);
}
