package com.optima.citas.controller;

import com.optima.citas.entity.RolEntity;
import com.optima.citas.services.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rol")
//http://localhost:8080/api/rol
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public ResponseEntity<RolEntity> registrarRoles(@RequestBody RolEntity rolEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.rolService.registrarRol(rolEntity));
    }
}
