package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {

    Optional<Roles> findByroleName(String roleName);
}
