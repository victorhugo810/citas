package com.optima.citas.controller;

import com.optima.citas.entity.UserEntity;
import com.optima.citas.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
//http://localhost:8080/api/user
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserEntity>> listarUsuariosPorRol(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.listarClientes(id));
    }

    @PostMapping
    public ResponseEntity<UserEntity> agregarUsuario(@RequestBody UserEntity userEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.registrarUsuario(userEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> actualizarUsuario(@PathVariable Integer id, @RequestBody UserEntity userEntity) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.actualizarUsuario(id, userEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        this.userService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}