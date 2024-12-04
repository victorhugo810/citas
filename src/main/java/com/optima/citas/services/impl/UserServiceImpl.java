package com.optima.citas.services.impl;

import com.optima.citas.entity.UserEntity;
import com.optima.citas.repository.UserRepository;
import com.optima.citas.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> listarClientes(Integer id) {
        return this.userRepository.listarUsuariosPorRol(id);
    }

    @Override
    public UserEntity registrarUsuario(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public UserEntity actualizarUsuario(Integer id, UserEntity userEntity) {
        if(id!=null){
            return this.userRepository.save(userEntity);

        }else{
            return null;
        }
    }

    @Override
    public void eliminarUsuario(Integer id) {

        this.userRepository.deleteById(id);
    }
}
