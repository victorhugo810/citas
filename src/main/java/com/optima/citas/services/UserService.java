package com.optima.citas.services;

import com.optima.citas.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> listarClientes(Integer id);
    UserEntity registrarUsuario(UserEntity userEntity);
    UserEntity actualizarUsuario(Integer id,UserEntity userEntity);

    void eliminarUsuario (Integer id);
}
