package com.optima.citas.services.impl;

import com.optima.citas.entity.RolEntity;
import com.optima.citas.repository.RolRepository;
import com.optima.citas.services.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public RolEntity registrarRol(RolEntity rolEntity) {
        return this.rolRepository.save(rolEntity);
    }
}
