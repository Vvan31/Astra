package com.project.astral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.astral.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
    
}
