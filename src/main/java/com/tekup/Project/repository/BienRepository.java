package com.tekup.Project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.Project.models.Bien;

public interface BienRepository extends JpaRepository<Bien, Long> {
    Optional<Bien> findByLebelle(String url);
    
    
}
