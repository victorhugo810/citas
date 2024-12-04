package com.optima.citas.services.impl;

import com.optima.citas.entity.CitasEntity;
import com.optima.citas.entity.UserEntity;
import com.optima.citas.repository.CitaRepository;
import com.optima.citas.services.CitasService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitasServiceImpl implements CitasService {
    private final CitaRepository citaRepository;

    public CitasServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<CitasEntity> listarCitasPorEstado(String estado) {
        return this.citaRepository.listarCitasPorEstado(estado);
    }

    @Override
    public List<CitasEntity> listarcitasPorAgenteyEstado(Integer id) {
        return this.citaRepository.listarCitasPorAgenteyEstado(id);
    }

    @Override
    public CitasEntity registrarCitas(CitasEntity citasEntity) {
        citasEntity.setFechaAsignacion(null);
        citasEntity.setFechaCulminada(null);
        citasEntity.setEstado("SA");
        citasEntity.setUsuarioAsignado(null);
        return  this.citaRepository.save(citasEntity);
    }

    @Override
    public CitasEntity asignarCitas(CitasEntity citasEntity, Integer id) {

        if(id!=null){

            Optional<CitasEntity> octenerCitas=this.citaRepository.findById(id);

            citasEntity.setId(id);
            citasEntity.setNombreProyecto(octenerCitas.get().getNombreProyecto());
            citasEntity.setConsulta(octenerCitas.get().getConsulta());
            citasEntity.setFechaRegistro(octenerCitas.get().getFechaRegistro());
            citasEntity.setFechaAsignacion(new Date());
            citasEntity.setFechaCulminada(octenerCitas.get().getFechaCulminada());
            citasEntity.setUsuarioCliente(octenerCitas.get().getUsuarioCliente());
            citasEntity.setEstado("PENDIENTE");

            return this.citaRepository.save(citasEntity);
        }else{
            return null;
        }

    }

    @Override
    public CitasEntity atenderCitas(Integer id, CitasEntity citasEntity) {
       if(id!=null){
           Optional<CitasEntity> optenerCitas=this.citaRepository.findById(id);

           citasEntity.setId(id);
           citasEntity.setNombreProyecto(optenerCitas.get().getNombreProyecto());
           citasEntity.setConsulta(optenerCitas.get().getConsulta());
           citasEntity.setConsulta(optenerCitas.get().getConsulta());
           citasEntity.setFechaRegistro(optenerCitas.get().getFechaRegistro());
           citasEntity.setFechaAsignacion(optenerCitas.get().getFechaAsignacion());
           citasEntity.setFechaCulminada(new Date());
           citasEntity.setEstado("COMPLETADO");
           citasEntity.setUsuarioCliente(optenerCitas.get().getUsuarioCliente());
           citasEntity.setUsuarioAsignado(optenerCitas.get().getUsuarioAsignado());

           return this.citaRepository.save(citasEntity);

        }else{
           return null;
        }
    }
}
