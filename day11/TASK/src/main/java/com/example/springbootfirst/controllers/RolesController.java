// RoleController.java
package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")// Enable CORS for frontend
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping("/roles")
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }
}
