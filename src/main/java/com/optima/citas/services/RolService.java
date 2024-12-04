package com.optima.citas.services;

import com.optima.citas.entity.RolEntity;
import org.springframework.stereotype.Repository;

public interface RolService {

    RolEntity registrarRol(RolEntity rolEntity);
}
