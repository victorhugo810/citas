package com.optima.citas.services;

import com.optima.citas.entity.CitasEntity;
import com.optima.citas.entity.UserEntity;

import java.util.List;

public interface CitasService {

    List<CitasEntity> listarCitasPorEstado(String estado);
    List<CitasEntity> listarcitasPorAgenteyEstado(Integer id);
    CitasEntity registrarCitas(CitasEntity citasEntity);
    CitasEntity asignarCitas(CitasEntity citasEntity, Integer id);
    CitasEntity atenderCitas(Integer id,CitasEntity citasEntity);

}
