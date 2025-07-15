package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.RegisterDetails; // ✅ import your entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails, Integer> {

    RegisterDetails findByEmail(String email);
    RegisterDetails findById(int id);
}
