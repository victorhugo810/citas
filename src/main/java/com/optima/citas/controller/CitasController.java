package com.optima.citas.controller;

import com.optima.citas.entity.CitasEntity;
import com.optima.citas.services.CitasService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    private final CitasService citasService;

    public CitasController(CitasService citasService) {
        this.citasService = citasService;
    }

    @GetMapping("/{estado}")
    public ResponseEntity<List<CitasEntity>> listarCitasPorEstados(@PathVariable String estado){
        return ResponseEntity.status(HttpStatus.OK).body(this.citasService.listarCitasPorEstado(estado));
    }

    @GetMapping("/agente/{id}")
    public ResponseEntity<List<CitasEntity>> listarCitasPorAgentesyEstados(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.citasService.listarcitasPorAgenteyEstado(id));
    }

    @PostMapping("/nueva-cita")
    public ResponseEntity<CitasEntity> registrarNuevaCita(@RequestBody CitasEntity citasEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.citasService.registrarCitas(citasEntity));
    }

    @PutMapping("/cita-asignada/{id}")
    public ResponseEntity<CitasEntity> asignarAgente(@PathVariable Integer id, @RequestBody CitasEntity citasEntity){
        return ResponseEntity.status(HttpStatus.OK).body(this.citasService.asignarCitas(citasEntity, id));
    }

    @PutMapping("/cita-culminada/{id}")
    public ResponseEntity<CitasEntity> atenderCita(@PathVariable Integer id, @RequestBody CitasEntity citasEntity){
        return ResponseEntity.status(HttpStatus.OK).body(this.citasService.atenderCitas(id, citasEntity));
    }

}
