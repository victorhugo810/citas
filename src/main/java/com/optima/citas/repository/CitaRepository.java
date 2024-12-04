package com.optima.citas.repository;

import com.optima.citas.entity.CitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<CitasEntity,Integer> {

    @Query("SELECT c FROM CitasEntity c" +
            " WHERE c.estado =:estado")
    List<CitasEntity> listarCitasPorEstado(@Param("estado") String estado);

    @Query("SELECT c FROM CitasEntity c" +
            " WHERE c.usuarioAsignado.id=:id AND c.estado='PENDIENTE'")
    List<CitasEntity> listarCitasPorAgenteyEstado(@Param("id") Integer id);
}
