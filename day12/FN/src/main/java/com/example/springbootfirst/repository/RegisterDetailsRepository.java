package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.RegisterDetails; // ✅ import your entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails, Integer> {

    RegisterDetails findByEmail(String email);
    RegisterDetails findById(int id);

    Optional<RegisterDetails> findByUserName(String userName);
    boolean existsByEmail(String email); // ✅ add this line

    Optional<RegisterDetails> findByEmpId(int id);
}
